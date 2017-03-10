package com.qhzk.ciep.ui.mine.setting;

import android.app.ProgressDialog;
import android.support.v7.widget.CardView;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.config.CacheConfig;
import com.qhzk.ciep.config.Constant;
import com.qhzk.ciep.ui.login.LoginActivity;
import com.qhzk.ciep.ui.mine.setting.feedback.FeedbackActivity;
import com.qhzk.ciep.ui.mine.setting.updatepassword.UpdatePasswordActivity;
import com.qhzk.ciep.utils.AppRuntimeUtil;
import com.qhzk.ciep.utils.SharedPrefUtil;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by pudao on 2016年12月20日11:51:38
 * 设置页面
 */

public class SettingActivity extends BaseActivity<SettingPresenter> implements SettingView {

    @BindView(R.id.update_password)
    CardView mUpdatePassword;
    @BindView(R.id.feed_back)
    CardView mFeedBack;
    @BindView(R.id.clear_cache)
    CardView mClearCache;
    @BindView(R.id.logout)
    Button mLogout;

    private ProgressDialog mProgressDialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initdata() {
        super.initdata();
    }

    @OnClick({R.id.update_password, R.id.feed_back, R.id.clear_cache, R.id.logout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.update_password:
                readyGo(UpdatePasswordActivity.class);
                break;
            case R.id.feed_back:
                readyGo(FeedbackActivity.class);
                break;
            case R.id.clear_cache:
                // 仅仅是retrofit的网络缓存
                File cacheFile = AppRuntimeUtil.getAppCatalog(CacheConfig.CACHE_INF);
                System.out.println(cacheFile.getAbsolutePath());
                File[] files = cacheFile.listFiles();
                long totalLength = 0;
                for (int i = 0; i < files.length; i++) {
                    totalLength = totalLength +files[i].length();
                    files[i].delete();
                }
                String total = Formatter.formatFileSize(this, totalLength);
                System.out.println("成功释放缓存:"+total);
                showToast("成功释放缓存:"+total);
                break;
            case R.id.logout:
                if (mLogout.getText().toString().equals("退出登录")){
                    mActivityPresenter.logout();
                }else{
                    readyGo(LoginActivity.class);
                }
                break;
        }
    }

    @Override
    public void showProgress() {
        if (mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("正在退出中");
        }
        mProgressDialog.show();
    }

    @Override
    public void hideProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onLogoutSuccess() {
        mLogout.setText("登录");
        SharedPrefUtil.savePrefString(this, Constant.LOGIN_USER, "");
        SharedPrefUtil.savePrefString(this, Constant.LOGIN_PASSWORD, "");
    }

    @Override
    public void onLogoutFailed() {
        showToast("退出失败");
    }
}
