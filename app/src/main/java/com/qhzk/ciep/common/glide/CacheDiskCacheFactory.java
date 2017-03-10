package com.qhzk.ciep.common.glide;


import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;

import java.io.File;

/**
 * Created by Thisdk on 2016/3/9.
 * 没卵用的类
 */
public class CacheDiskCacheFactory extends DiskLruCacheFactory {

    public CacheDiskCacheFactory(final File cachedir, int diskCacheSize) {
        super(new CacheDirectoryGetter() {
            @Override
            public File getCacheDirectory() {
                return cachedir;
            }
        }, diskCacheSize);
    }

}
