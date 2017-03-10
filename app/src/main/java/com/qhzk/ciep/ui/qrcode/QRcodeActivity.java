package com.qhzk.ciep.ui.qrcode;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Build;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.entity.EnterpriseEntity;
import com.qhzk.ciep.entity.QRcodeEntity;
import com.qhzk.ciep.entity.VideoEntity;
import com.qhzk.ciep.library_zxing.activity.CaptureFragment;
import com.qhzk.ciep.library_zxing.activity.CodeUtils;
import com.qhzk.ciep.ui.enterprise.EnterpriseActivity;
import com.qhzk.ciep.ui.video.VideoActivity;

/**
 * Created by Thisdk on 2016/9/2.
 * 二维码扫描页面
 */

public class QRcodeActivity extends BaseActivity<QRcodePresenter> implements QRcodeView {

    private CaptureFragment mCaptureFragment;

    private QRcodeEntity mQRcodeEntity;

    @Override
    public int getLayoutId() {
        return R.layout.activity_qrcode;
    }

    @Override
    protected void initview() {
        super.initview();

        mToolbar.setNavigationOnClickListener(v -> finish());
    }


    @Override
    protected void onResume() {
        super.onResume();
        // 针对6.0才去做动态权限处理
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            applyPermissions(Manifest.permission.CAMERA, 1024);
        } else {
            openCapture();
        }
    }

    @Override
    protected void onApplyPermissionsResult(int requestCode, boolean isSuccess) {
        super.onApplyPermissionsResult(requestCode, isSuccess);
        if (requestCode == 1024 && isSuccess) {
            openCapture();
        } else {
            showToast("获取摄像头权限失败");
            finish();
        }
    }

    private void openCapture() {
        mCaptureFragment = new CaptureFragment();
        mCaptureFragment.setAnalyzeCallback(analyzeCallback);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, mCaptureFragment)
                .commitAllowingStateLoss();
    }

    /**
     * 二维码解析回调函数
     */
    CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {
        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            try {
                mQRcodeEntity = new Gson().fromJson(result, QRcodeEntity.class);
            } catch (Exception e) {
                showToast("识别失败!");
                finish();
                return;
            }
            mActivityPresenter.getQRcodeInfo(mQRcodeEntity.getAction(), mQRcodeEntity.getParams());
        }

        @Override
        public void onAnalyzeFailed() {
            showToast("识别失败!");
            finish();
        }
    };


    @Override
    public void onQRcodeInfo(LinkedTreeMap map) {
        if (map == null) {
            showToast("识别失败!");
        } else {
            Gson gson = new Gson();
            String json = gson.toJson(map);
            switch (mQRcodeEntity.getCmd()) {
                case 1: //企业信息
                    EnterpriseEntity enterpriseEntity = gson.fromJson(json, EnterpriseEntity.class);
                    if (enterpriseEntity == null) {
                        showToast("识别失败!");
                    } else
                        readyGo(EnterpriseActivity.class, EnterpriseActivity.newBundle(enterpriseEntity));
                    break;
                case 2: //点播视频
                    VideoEntity videoEntity = gson.fromJson(json, VideoEntity.class);
                    if (videoEntity == null) {
                        showToast("识别失败!");
                    } else readyGo(VideoActivity.class, VideoActivity.newBundle(videoEntity));
                    break;
                case 3: // 直播视频

                    break;
                default:
                    showToast("识别失败!");
                    break;
            }
        }
        finish();
    }
}
