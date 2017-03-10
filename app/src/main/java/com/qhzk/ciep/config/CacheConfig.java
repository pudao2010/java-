package com.qhzk.ciep.config;

/**
 * Created by Thisdk on 2016/3/9.
 * 缓存配置的常量
 */
public class CacheConfig {

    /**
     * 缓存目录
     * <p/>
     * 默认使用外置存储卡.如果没有外置存储卡.则使用应用目录空间
     */

    //图片缓存目录名称
    public static final String CACHE_IMAGE = "image";

    //网络接口缓存目录名称
    public static final String CACHE_INF = "inf";

    //文件下载缓存目录名称
    public static final String CACHE_FILE = "file";

    //缓存目录的集合,用于统一初始化
    public static final String[] CATALOG_CACHE = {CACHE_IMAGE, CACHE_INF, CACHE_FILE};

    /**
     * Glide 内存缓存大小  单位:字节
     * 如果大小为 0 ,根据手机配置动态计算最佳值
     * 如果大于 0 , 则按照定义的值.
     */
    public static final int GLIDE_MEMORY_CACHE_SIZE = 0;

    /**
     * Glide 位图缓存大小  单位:字节
     * 如果大小为 0 ,根据手机配置动态计算最佳值
     * 如果大于 0 , 则按照定义的值.
     */
    public static final int GLIDE_BITMAP_POOL_SIZE = 0;

    /**
     * Glide 磁盘缓存大小  单位:字节
     */
    public static final int GLIDE_DISK_CACHE_SIZE = 1024 * 1024 * 50;  //100M

    /**
     * Retrofit网络接口缓存大小  单位:字节
     * 注 : 仅仅对GET请求进行缓存.其他不会缓存
     */
    public static final int RETROFIT_INF_CACHE_SIZE = 1024 * 1024 * 15;  //15M


    /**
     * 网络请求缓存头部
     */
    @Deprecated
    public static final String CACHE_MAX_AGE = "Cache-Max-Age";


}
