package com.qhzk.ciep.ui.resetpasswd;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by QixiongYuan on 2016/11/8.
 * 找回密码页面
 */

public class ResetPasswdActivity extends BaseActivity {

    public String mEmail;
    public String mCode;
    @BindView(R.id.container)
    FrameLayout mContainer;

    @Override
    public int getLayoutId() {
        return R.layout.activity_resetpasswd;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void initdata() {
        super.initdata();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, new InputUsernameFragment());
        transaction.commit();
    }

}
