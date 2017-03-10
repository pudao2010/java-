package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.qhzk.ciep.CiepApplication;
import com.qhzk.ciep.common.okhttp.cookie.CookieJarImpl;
import com.qhzk.ciep.common.okhttp.cookie.store.CookieStore;
import com.qhzk.ciep.common.okhttp.cookie.store.PersistentCookieStore;
import com.qhzk.ciep.repository.remote.modle.ResultModle;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Cookie;

/**
 * 2016年12月27日11:47:18
 */
public abstract class CiepProtocol {

    public Map<String,String> mParmasMap;

    private Callback mCallback;
    private Gson gson;

    public CiepProtocol(Callback mCallback) {
        this.mCallback = mCallback;
    }

    /**
     *  上传数据
     */
    public void uploadDataByGet() {
        loadDataFromNetByGet();
    }

    /**
     *  上传数据
     */
    public void uploadDataByPost() {
        loadDataFromNetByPost();
    }

    /**
     * 从网络获取数据
     */
    private void loadDataFromNetByGet() {
        //从网络加载数据
        String url = getUrl();
        OkHttpUtils
                .get()
                .url(url)
                .params(getParmasMap())
                .headers(getHeadersMap())
                .build()
                .execute(new StringCallback() {
                             @Override
                             public void onError(Call call, Exception e, int id) {
                                 if (mCallback != null) {
                                     mCallback.onError(call, e, id);
                                 }
                             }

                             @Override
                             public void onResponse(String response, int id) {
                                 System.out.println("结果===="+response);
                                 System.out.println("id======"+id);
                                 if (gson == null){
                                     gson = new Gson();
                                 }
                                 ResultModle resultModle = gson.fromJson(response, ResultModle.class);
                                 if (resultModle.getCode() == 0){
                                     System.out.println("========成功了=========");
                                     if (mCallback != null) {
                                         mCallback.onSuccess();
                                     }
                                 }else{
                                     System.out.println("========失败了=========");
                                     if (mCallback != null) {
                                         mCallback.onFailed();
                                     }
                                 }
                             }
                         }
                );
    }
    private void loadDataFromNetByPost(){
        //从网络加载数据
        String url = getUrl();
       /* PostFormBuilder postFormBuilder = */OkHttpUtils
                .post()
                .url(url)
                .params(getParmasMap())
                .headers(getHeadersMap())
                .build()
                .execute(new StringCallback() {
                             @Override
                             public void onError(Call call, Exception e, int id) {
                                 if (mCallback != null) {
                                     mCallback.onError(call, e, id);
                                 }
                             }

                             @Override
                             public void onResponse(String response, int id) {
                                 if (gson == null){
                                     gson = new Gson();
                                 }
                                 ResultModle resultModle = gson.fromJson(response, ResultModle.class);
                                 if (resultModle.getCode() == 0){
                                     if (mCallback != null) {
                                         mCallback.onSuccess();
                                     }
                                 }else{
                                     if (mCallback != null) {
                                         mCallback.onFailed();
                                     }
                                 }
                             }
                         }
                );
    }
    /**
     * 决定url
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
     * 添加请求头, 从cookie中获取
     */
    protected Map<String, String> getHeadersMap() {
        HashMap<String, String> headersMap = new HashMap<>();
        CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(CiepApplication.getApplication()));
        CookieStore cookieStore = cookieJar.getCookieStore();
        String tempCookies = "";
        if (cookieStore != null) {
            for (Cookie c : cookieStore.getCookies()){
                tempCookies += (c.name() + "=" +c.value())+";";
            }
        }
        headersMap.put("Cookie", tempCookies);
        return headersMap;
//        return null;
    }

    public interface Callback{
        void onError(Call call, Exception e, int id);     // 网络错误

        void onSuccess();   // 上传成功

        void onFailed();    // 上传失败
    }

}
