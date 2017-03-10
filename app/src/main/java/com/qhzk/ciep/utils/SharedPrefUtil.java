package com.qhzk.ciep.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/12/19.
 * 用来保存用户的登录信息和个人资料
 */

public class SharedPrefUtil {

    public static String getPrefString(Context context, String key, final String defaultValue) {
        /*final SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getString(key, defaultValue);*/
        SharedPreferences userinfo = context.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        return userinfo.getString(key, defaultValue);
    }

    public static void savePrefString(Context context, final String key, final String value) {
        SharedPreferences userinfo = context.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        userinfo.edit().putString(key, value).apply();
    }

    public static boolean getPrefBoolean(Context context, String key){
        SharedPreferences userinfo = context.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        return userinfo.getBoolean(key, false);
    }

    public static void savePrefBoolean(Context context, String key, boolean value){
        SharedPreferences userinfo = context.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        userinfo.edit().putBoolean(key, value).apply();
    }
}
