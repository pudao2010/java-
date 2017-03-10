package com.qhzk.ciep.common.okhttp.callback;


import com.qhzk.ciep.common.okhttp.OkHttpClientManage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Response;

/**
 * Created by zhy on 15/12/15.
 */
public abstract class FileCallBack extends Callback<File> {

    public abstract void inProgress(float progress, long total);

    private String mFileName;

    public FileCallBack() {
        this(System.currentTimeMillis() + ".file");
    }

    public FileCallBack(String fileName) {
        mFileName = fileName;
    }

    @Override
    public File parseNetworkResponse(Response response) throws Exception {
        return saveFile(response);
    }

    public File saveFile(Response response) throws IOException {
        InputStream is = null;
        byte[] buf = new byte[2048];
        int len = 0;
        FileOutputStream fos = null;
        try {
            is = response.body().byteStream();
            final long total = response.body().contentLength();
            long sum = 0;
            File file = new File(OkHttpClientManage.getOkHttpClientManage().getDownloadFileCache(), mFileName);
            fos = new FileOutputStream(file);
            while ((len = is.read(buf)) != -1) {
                sum += len;
                fos.write(buf, 0, len);
                final long finalSum = sum;
                OkHttpClientManage.getOkHttpClientManage().getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        if (total == -1) {
                            inProgress(finalSum, total);
                        } else {
                            inProgress(finalSum * 1.0f / total, total);
                        }
                    }
                });
            }
            fos.flush();
            return file;
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
