package com.qhzk.ciep.common.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;
import com.qhzk.ciep.config.CacheConfig;
import com.qhzk.ciep.utils.AppRuntimeUtil;

/**
 * Created by Thisdk on 2016/3/9.
 * 没卵用的类
 */
public class SettingGlideModule implements GlideModule {

    private static String TAG = SettingGlideModule.class.getSimpleName();

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        int memoryCacheSize = calculator.getMemoryCacheSize();
        int bitmapPoolSize = calculator.getBitmapPoolSize();
        memoryCacheSize = CacheConfig.GLIDE_MEMORY_CACHE_SIZE > 0 ? CacheConfig.GLIDE_MEMORY_CACHE_SIZE : (int) (1.25f * memoryCacheSize);
        bitmapPoolSize = CacheConfig.GLIDE_BITMAP_POOL_SIZE > 0 ? CacheConfig.GLIDE_BITMAP_POOL_SIZE : (int) (1.25f * bitmapPoolSize);
        builder.setMemoryCache(new LruResourceCache(memoryCacheSize));
        builder.setBitmapPool(new LruBitmapPool(bitmapPoolSize));
        // 图片质量
        DecodeFormat decodeFormat = DecodeFormat.PREFER_RGB_565;
        builder.setDecodeFormat(decodeFormat);
        builder.setDiskCache(new CacheDiskCacheFactory(AppRuntimeUtil.getAppCatalog(CacheConfig.CACHE_IMAGE), CacheConfig.GLIDE_DISK_CACHE_SIZE));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }


}
