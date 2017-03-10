package com.qhzk.ciep.config;

/**
 *  Created by Thisdk on 2016/3/7.
 *  Url地址的常量
 */
public class ServiceConfig {

    public static final String BASE_QRCODE = "http://120.76.74.105:80/qrcode/qr!gen.action?cmd=4&id=";
    public static String BASE_URL;
    public static String BASE_IMAGE_URL;
    public static final String BASEURL = "http://www.gtpnc.com/"; //域名

    public static final int NETWORD_TIMEOUT = 12;

    private static final String PROTOCOL_HTTP = "http://";

    private static final String DOMAIN = "120.76.74.105";
    private static final String PORT = ":80";
    private static final String VERSION = "ciep_new";

    static {
//        BASE_URL = PROTOCOL_HTTP + DOMAIN + PORT + "/"/* + VERSION + "/"*/;
        BASE_URL = BASEURL;
        BASE_IMAGE_URL = PROTOCOL_HTTP + DOMAIN + ":8085/ciep_new/";
    }

}
