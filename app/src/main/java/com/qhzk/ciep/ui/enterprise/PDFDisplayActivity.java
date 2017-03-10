package com.qhzk.ciep.ui.enterprise;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.joanzapata.pdfview.PDFView;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.utils.ServiceUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;

import butterknife.BindView;
import okhttp3.Call;

/**
 * Created by Thisdk on 2016/9/2.
 * 企业信息页面,展示PDF文档
 */

public class PDFDisplayActivity extends BaseActivity {

    private static final String BUNDLE_URL = "BUNDLE_URL";

    PDFView mPdfview;

    @BindView(R.id.loading_progress)
    ProgressBar mLoadingProgress;
    @BindView(R.id.layout)
    FrameLayout mLayout;

    private String mPdfFileUrl;
    private String fileName;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pdf_display;
    }

    public static Bundle newActivityBundle(String url) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_URL, url);
        return bundle;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        mPdfFileUrl = savedInstanceState.getString(BUNDLE_URL, null);
    }

    @Override
    protected void initview() {
        super.initview();

        if (TextUtils.isEmpty(mPdfFileUrl)) {
            finish();
            return;
        }

        mPdfFileUrl = ServiceUtil.subBaseUrl(mPdfFileUrl);
        System.out.println("pdf地址============"+mPdfFileUrl);
        mToolbar.setNavigationOnClickListener(v -> finish());

    }

    @Override
    protected void initdata() {
        super.initdata();
        fileName = String.valueOf(mPdfFileUrl.hashCode()) + ".pdf";
//        if (DownloadModule.fileExists(fileName)) {
//            loadPdfFile(DownloadModule.getFile(fileName));
//        } else {
//            DownloadModule.asyncDonwloadFile(mPdfFileUrl, fileName, new DownloadModule.DownloadFileCallback() {
//                @Override
//                public void onError(String error) {
//                    Log.i(TAG, "onError:" + error);
//                    showToast("下载文件失败");
//                    mLoadingProgress.setVisibility(View.INVISIBLE);
//                }
//
//                @Override
//                public void onSuccess(File file) {
//                    Log.i(TAG, "onSuccess");
//                    loadPdfFile(file);
//                }
//
//                @Override
//                public void progress(float progress, long total) {
//                }
//
//            });
//        }
        // 申请权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            applyPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, 100);
        } else {
           writeToSD();
        }
    }

    private void writeToSD() {
        //将资源中的文件重写到sdcard中
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), fileName);
        if (!file.exists()) {
            OkHttpUtils//
                    .get()//
                    .url(mPdfFileUrl)//
                    .build()//
                    .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), fileName)//
                    {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            showToast("下载失败");
                        }

                        @Override
                        public void onResponse(File response, int id) {
                            mLoadingProgress.setVisibility(View.GONE);
                            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), fileName);
                            loadPdfFile(file);
                        }

                    });
        } else {
            loadPdfFile(file);
        }
    }

    @Override
    protected void onApplyPermissionsResult(int requestCode, boolean isSuccess) {
        super.onApplyPermissionsResult(requestCode, isSuccess);
        if (requestCode == 100 && isSuccess) {
            writeToSD();
        } else {
            showToast("申请写入SD卡失败");
            finish();
        }
    }

    private void loadPdfFile(File file) {
        mLoadingProgress.setVisibility(View.INVISIBLE);
        mPdfview = new PDFView(this, null);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        mPdfview.setLayoutParams(params);
        mLayout.addView(mPdfview);
        mPdfview.fromFile(file)
                .defaultPage(1)
                .showMinimap(false)
                .enableSwipe(true)
                .load();
    }

}
