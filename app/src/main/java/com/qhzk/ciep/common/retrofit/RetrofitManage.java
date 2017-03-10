package com.qhzk.ciep.common.retrofit;


import com.qhzk.ciep.config.ServiceConfig;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Thisdk on 2016/3/8.
 *
 */
public class RetrofitManage {

    private static RetrofitManage mRetrofitManage;

    public static void init(OkHttpClient okHttpClient) {
        mRetrofitManage = new RetrofitManage(okHttpClient);
    }

    private Retrofit mRetrofit;

    private Map<Class<?>, Object> mApis;
    // 私有构造方法，标准的单例设计模式
    private RetrofitManage(OkHttpClient okHttpClient) {

        mApis = new HashMap<Class<?>, Object>();

        mRetrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(ServiceConfig.BASE_URL)
//                .baseUrl(ServiceConfig.BASE_IMAGE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    /**
     * 单例模式的Api实例获取
     *
     * @param clazz 需要获取实例的类
     * @param <T>   泛型
     * @return 实例
     */
    public static <T> T getApiInstance(Class<T> clazz) {
        T object = (T) mRetrofitManage.mApis.get(clazz);
        if (object == null) {
            object = mRetrofitManage.mRetrofit.create(clazz);
            mRetrofitManage.mApis.put(clazz, object);
        }
        return object;
    }

}
