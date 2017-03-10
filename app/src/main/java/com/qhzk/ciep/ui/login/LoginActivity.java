package com.qhzk.ciep.ui.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.config.Constant;
import com.qhzk.ciep.ui.main.MainActivity;
import com.qhzk.ciep.ui.register.RegisterActivity;
import com.qhzk.ciep.ui.resetpasswd.ResetPasswdActivity;
import com.qhzk.ciep.utils.SharedPrefUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @BindView(R.id.username)
    EditText mUsername;
    @BindView(R.id.passwd)
    EditText mPassword;
    @BindView(R.id.login)
    Button mLogin;
    @BindView(R.id.register)
    TextView mRegister;
    @BindView(R.id.reset_passwd)
    TextView mResetPasswd;
    @BindView(R.id.wechat)
    ImageView mWechat;
    // 是否为个人用户
    private boolean isPerson = false;
    private String username;
    private String password;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initview() {
        super.initview();
        //  ToolBar的返回键
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void initdata() {
        super.initdata();
    }

    @OnClick({R.id.login, R.id.register, R.id.reset_passwd, R.id.wechat})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                username = mUsername.getText().toString().trim();
                password = mPassword.getText().toString().trim();

                checkPersonOrNot(username);

                break;
            case R.id.register:
                //TODO 进入注册页面
                readyGo(RegisterActivity.class);
                break;
            case R.id.reset_passwd:
                //TODO 进入重置密码页面
                readyGo(ResetPasswdActivity.class);
                break;
            case R.id.wechat:
                //TODO 调用微信第三方登录
                showToast("抱歉,暂不支持微信登录");
                break;
        }
    }

    // 判断登录账号是否为个人账号, APP仅供个人用户登录
    private void checkPersonOrNot(String username) {
        mActivityPresenter.checkPersonOrNot(username);
    }


    @Override
    public void onLoginSuccess(String usercode, String password) {
        // 保存的是已经加密后
        SharedPrefUtil.savePrefString(this, Constant.LOGIN_USER, usercode);
        SharedPrefUtil.savePrefString(this, Constant.LOGIN_PASSWORD, password);
        readyGo(MainActivity.class);
        finish();
    }

    @Override
    public void onLoginFailed() {
        // 不作处理,网络请求对错误已做统一处理
    }

    @Override
    public void onCheckSuccess() {
        isPerson = true;
        if (isPerson){
            mActivityPresenter.login(username, password);
        } else{
            showToast("app端仅支持个人用户登录使用");
        }
    }

    @Override
    public void onError(Exception e) {
        showToast("网络错误:"+e);
    }

    @Override
    public void onFailed() {

    }


}
