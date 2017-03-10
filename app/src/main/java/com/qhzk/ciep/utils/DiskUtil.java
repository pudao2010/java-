package com.qhzk.ciep.utils;

import android.os.Environment;

/**
 * Created by Thisdk on 2016/3/9.
 */
public class DiskUtil {

    /**
     * 判断是否有外置存储卡
     *
     * @return
     */
    public static boolean isSDCardEnable() {
        try {
            return Environment
                    .getExternalStorageState()
                    .equals(Environment.MEDIA_MOUNTED);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
