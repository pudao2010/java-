package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.Call;

/**
 * 2016年12月21日23:19:28
 */
public abstract class BaseProtocol<RESTYPE> {
    public Map<String, String> mParmasMap;

    /**
     * 加载数据
     *
     * @return
     */
    public void loadDataByGet(Callback callback) {
        //在网络
        loadDataFromNetByGet(callback);
    }

    public void loadDataByPost(Callback callback) {
        //在网络
        loadDataFromNetByPost(callback);
    }

    /**
     * 从网络获取数据
     * @throws IOException
     */
    private void loadDataFromNetByGet(final Callback callback) {
        //从网络加载数据
        String url = getUrl();
        //?pageIndex=0&catalog=1&pageSize=20
        OkHttpUtils
                .get()
                .url(url)
                .params(getParmasMap())
                .headers(getHeadersMap())
                .build()
                .execute(new StringCallback() {
                             @Override
                             public void onError(Call call, Exception e, int id) {
                                 if (callback != null) {
                                     callback.onError(call, e, id);
                                 }
                             }

                             @Override
                             public void onResponse(String response, int id) {
                                 RESTYPE restype = parseJson(response);
                                 if (callback != null) {
                                     callback.onResponse(restype, id);
                                 }
                             }
                         }
                );
    }


    /**
     * 发起post请求
     *
     * @param callback
     */
    private void loadDataFromNetByPost(final Callback callback) {
        //从网络加载数据
        String url = getUrl();
        //?pageIndex=0&catalog=1&pageSize=20
        File file = null;

        Map<String, File> fileMap = getFileMap();

        PostFormBuilder postFormBuilder = OkHttpUtils
                .post()
                .url(url)
                .params(getParmasMap())
                .headers(getHeadersMap());


        //遍历集合fileMap,动态添加图片
        if (fileMap != null) {//需要上传图片
            for (Map.Entry<String, File> info : fileMap.entrySet()) {
                String key = info.getKey();
                File value = info.getValue();
                postFormBuilder.addFile(key, value.getName(), value);
            }
        }

        postFormBuilder.build()
                .execute(new StringCallback() {
                             @Override
                             public void onError(Call call, Exception e, int id) {
                                 if (callback != null) {
                                     callback.onError(call, e, id);
                                 }
                             }

                             @Override
                             public void onResponse(String resXml, int id) {
                                 RESTYPE restype = parseJson(resXml);
                                 if (callback != null) {
                                     callback.onResponse(restype, id);
                                 }
                             }
                         }
                );
    }

    public interface Callback<RESTYPE> {
        void onError(Call call, Exception e, int id);

        void onResponse(RESTYPE restype, int id);
    }

    /**
     * 基类完成统一的泛型解析
     *
     * @param response
     * @return
     */
    private RESTYPE parseJson(String response) {
        Type type = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Gson gson = new Gson();
        return gson.fromJson(response, type);

    }


    /**
     * 决定url
     *
     * @return
     */
    @NonNull
    public abstract String getUrl();


    /**
     * 传递对应的参数信息
     */
    protected Map<String, String> getParmasMap() {
        return null;
    }

    /**
     * 添加请求头
     *
     * @return
     */
    protected Map<String, String> getHeadersMap() {
        return null;
    }

    /**
     * 添加需要上传的图片
     *
     * @return
     */
    protected Map<String, File> getFileMap() {
        return null;
    }

}
