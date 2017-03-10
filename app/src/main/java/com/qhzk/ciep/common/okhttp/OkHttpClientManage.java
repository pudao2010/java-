package com.qhzk.ciep.common.okhttp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.qhzk.ciep.BuildConfig;
import com.qhzk.ciep.common.okhttp.callback.Callback;
import com.qhzk.ciep.common.okhttp.request.RequestCall;
import com.qhzk.ciep.config.CacheConfig;
import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.network.PersistentCookieJar;
import com.qhzk.ciep.network.cache.SetCookieCache;
import com.qhzk.ciep.network.persistence.SharedPrefsCookiePersistor;
import com.qhzk.ciep.utils.AppRuntimeUtil;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;


/**
 * Created by Thisdk on 2016/3/9.
 * <p/>
 * 该管理类拥有双重网络实例
 * 1.用于请求rest网络接口的实例,该实例带有缓存.
 * 2.用于请求除rest网络接口一切请求的实例,该实例不进行缓存. 上层自行实现对应的缓存机制
 */
public class OkHttpClientManage {

    private static String TAG = OkHttpClientManage.class.getSimpleName();

    /**
     * 没有通过拦截器缓存的实例
     */
    private OkHttpClient okHttpNoCacheClient;

    /**
     * 拥有拦截器缓存的实例
     */
    private OkHttpClient okHttpCacheClient;

    private Handler mHandler;

    private File mDownloadFileCache;

    private static OkHttpClientManage okHttpClientManage;

    public static void init(Context context) {
        okHttpClientManage = new OkHttpClientManage(context);
    }

    public static OkHttpClient getOkHttpCacheClient() {
        return okHttpClientManage.okHttpCacheClient;
    }

    public static OkHttpClient getOkHttpNoCacheClient() {
        return okHttpClientManage.okHttpNoCacheClient;
    }

    public static OkHttpClientManage getOkHttpClientManage() {
        return okHttpClientManage;
    }

    private OkHttpClientManage() {
    }

    private OkHttpClientManage(Context context) {

        mHandler = new Handler(Looper.getMainLooper());

        OkHttpClient.Builder okHttoBuilder = new OkHttpClient.Builder();
        //设置超时时间
        okHttoBuilder.connectTimeout(ServiceConfig.NETWORD_TIMEOUT, TimeUnit.SECONDS);
        okHttoBuilder.writeTimeout(ServiceConfig.NETWORD_TIMEOUT, TimeUnit.SECONDS);
        okHttoBuilder.readTimeout(ServiceConfig.NETWORD_TIMEOUT, TimeUnit.SECONDS);
        //自动管理cookie
//        okHttoBuilder.cookieJar(new CookieJarImpl(new PersistentCookieStore(context)));
        okHttoBuilder.cookieJar(new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context)));
        //添加拦截器
        if (BuildConfig.DEBUG){
            okHttoBuilder.addInterceptor(new LoggerInterceptor("qhzk:retrofit", true));
        }
        //文件缓存目录
        mDownloadFileCache = AppRuntimeUtil.getAppCatalog( CacheConfig.CACHE_FILE);
        //设置缓存
        Cache restCache = new Cache(AppRuntimeUtil.getAppCatalog(CacheConfig.CACHE_INF), CacheConfig.RETROFIT_INF_CACHE_SIZE);
        okHttoBuilder.cache(restCache);
        okHttpCacheClient = okHttoBuilder.build();
    }

    public <T> void execute(RequestCall requestCall, Callback<T> callback) {
        if (callback == null) callback = Callback.CALLBACK_DEFAULT;
        final Callback<T> finalCallback = callback;
        requestCall.getCall().enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                sendFailResultCallback(call, e, finalCallback);
            }

            @Override
            public void onResponse(final Call call, final Response response) {
                try {
                    T o = finalCallback.parseNetworkResponse(response);
                    OkHttpClientManage.getOkHttpClientManage().sendSuccessResultCallback(o, finalCallback);
                } catch (Exception e) {
                    sendFailResultCallback(call, e, finalCallback);
                }

            }
        });
    }

    private <T> void sendFailResultCallback(final Call call, final Exception e, final Callback<T> callback) {
        if (callback == null) return;
        mHandler.post(() -> {
            callback.onError(call, e);
            callback.onAfter();
        });
    }

    private <T> void sendSuccessResultCallback(final T obj, final Callback<T> callback) {
        if (callback == null) return;
        mHandler.post(() -> {
            callback.onResponse(obj);
            callback.onAfter();
        });
    }

    public Handler getHandler() {
        return mHandler;
    }

    public File getDownloadFileCache() {
        return mDownloadFileCache;
    }
}
