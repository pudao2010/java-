package com.qhzk.ciep.common.okhttp;


import com.qhzk.ciep.common.okhttp.builder.GetBuilder;
import com.qhzk.ciep.common.okhttp.callback.FileCallBack;

import java.io.File;

import okhttp3.Call;

/**
 * Created by Thisdk on 2016/5/6.
 * 通用下载文件专用类
 */
public class DownloadModule {

    public interface DownloadFileCallback {
        void onError(String error);

        void onSuccess(File file);

        void progress(float progress, long total);
    }

    public static void asyncDonwloadFile(String url, String fileName, final DownloadFileCallback callback) {
        new GetBuilder().url(url).build().execute(new FileCallBack(fileName) {
            /**
             * 下载文件进度回调,这里需要注意的是,如果总字节数是-1,则表示无法获取文件长度
             * progress的值不再是百分比,而是下载字节数
             * @param progress 百分比/总长度为-1时变成下载字节数
             * @param total 文件总长度
             */
            @Override
            public void inProgress(float progress, long total) {
                if (callback != null) {
                    callback.progress(progress, total);
                }
            }

            @Override
            public void onError(Call call, Exception e) {
                if (callback != null) {
                    callback.onError(e.getMessage());
                }
            }

            @Override
            public void onResponse(File response) {
                if (callback != null) {
                    callback.onSuccess(response);
                }
            }
        });
    }

    public static boolean fileExists(String fileName) {
        File file = new File(OkHttpClientManage.getOkHttpClientManage().getDownloadFileCache(), fileName);
        return file.exists();
    }

    public static File getFile(String fileName) {
        return new File(OkHttpClientManage.getOkHttpClientManage().getDownloadFileCache(), fileName);
    }

}
