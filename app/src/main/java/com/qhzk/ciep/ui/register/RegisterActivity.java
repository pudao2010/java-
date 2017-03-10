package com.qhzk.ciep.ui.register;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.config.Constant;
import com.qhzk.ciep.utils.SharedPrefUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by QixiongYuan on 2016/11/8.
 * 注册页面
 */

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterView {
    public static final String REGESTER_EMAIL = "regester_email";
    @BindView(R.id.toolbar_right_title)
    TextView mToolbarRightTitle;
    @BindView(R.id.layout_radio)
    RadioGroup mLayoutRadio;
    @BindView(R.id.username)
    EditText mUsername;
    @BindView(R.id.passwd)
    EditText mPasswd;
    @BindView(R.id.register)
    Button mRegister;
    private String mCustname;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void initdata() {
        super.initdata();
    }

    @Override
    public void onRegisterSuccess() {
        SharedPrefUtil.savePrefString(this, Constant.LOGIN_USER, mUsername.getText().toString().trim());
        SharedPrefUtil.savePrefString(this, Constant.LOGIN_PASSWORD, mPasswd.getText().toString().trim());
        Bundle bundle = new Bundle();
        bundle.putString(REGESTER_EMAIL, mCustname);
        readyGo(RegisterSuccessActivity.class, bundle);
    }

    @OnClick({R.id.toolbar_right_title, R.id.register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_right_title:
                finish();
                break;
            case R.id.register:
                int checkedRadioButtonId = mLayoutRadio.getCheckedRadioButtonId();
                // 目前App端只针对个人用户注册
                String custtype = null;
                switch (checkedRadioButtonId) {
                    case R.id.radio_button_person:
                        custtype = "P";
                        break;
                    case R.id.radio_button_unit:
//                        custtype = "I";
                        custtype = "P";
                        break;
                    case R.id.radio_button_media:
//                        custtype = "M";
                        custtype = "P";
                        break;
                }
                mCustname = mUsername.getText().toString().trim();
                String password = mPasswd.getText().toString().trim();
                // 使用MD5加密后的密码进行注册
//                String md5Password = MD5Util.MD5(password);
                mActivityPresenter.register(custtype, mCustname, password, password);
                break;
        }
    }
}
