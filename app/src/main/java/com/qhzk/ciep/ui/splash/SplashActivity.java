package com.qhzk.ciep.ui.splash;

import android.os.Handler;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.config.Constant;
import com.qhzk.ciep.ui.main.MainActivity;
import com.qhzk.ciep.utils.SharedPrefUtil;

/**
 * 欢迎界面
 */
public class SplashActivity extends BaseActivity {
    private Handler mHandler = new Handler();

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(() -> {
            readyGo(MainActivity.class);
            SharedPrefUtil.savePrefBoolean(this, Constant.ISFIRSTIN, false);
            finish();
        },800);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mHandler != null) {
            mHandler.removeCallbacks(null);
        }
    }
}
