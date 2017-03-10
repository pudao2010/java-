package com.qhzk.ciep.utils;

import com.qhzk.ciep.CiepApplication;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Thisdk on 2016/3/10.
 * 包含MD5加密算法
 */
public class AppRuntimeUtil {

    private static String mAppCacheSize = "";

    public static File getAppCatalog(String catalogKey) {
        return getAppApplication().getAppCatalog(catalogKey);
    }

    public static File getApplicationCacheHome() {
        return getAppApplication().getCacheHome();
    }

    public static File getApplicationFileHome() {
        return getAppApplication().getFileHome();
    }

    public static int getAppVersionCode() {
        return getAppApplication().getAppVersionCode();
    }

    public static String getAppVersionName() {
        return getAppApplication().getAppVersionName();
    }

    private static CiepApplication getAppApplication() {
        return CiepApplication.getApplication();
    }

    public static String getAppCacheSize() {
        return mAppCacheSize;
    }

    public static void setAppCacheSize(String mAppCacheSize) {
        AppRuntimeUtil.mAppCacheSize = mAppCacheSize;
    }

    public static String md5(String string) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }

}
