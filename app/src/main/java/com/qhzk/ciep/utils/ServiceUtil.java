package com.qhzk.ciep.utils;

import com.qhzk.ciep.config.ServiceConfig;

/**
 * Created by Thisdk on 2016/9/8.
 *
 */

public class ServiceUtil {

    public static String subBaseUrl(String url) {
        try {
            char[] chars = url.toCharArray();
            if (chars[0] == '/') url = new String(chars, 1, chars.length - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceConfig.BASE_URL + url;
    }

    public static String subImageUrl(String url) {
        return ServiceConfig.BASE_URL + url;
    }

}
