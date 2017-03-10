package com.qhzk.ciep.ui.register;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by QixiongYuan on 2016/11/8.
 */

public class RegisterSuccessActivity extends BaseActivity {

    @BindView(R.id.activity_register_success_email)
    TextView mActivityRegisterSuccessEmail;
    @BindView(R.id.register_finish)
    Button mRegisterFinish;
    private String mRegisterEmail;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register_success;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
        mActivityRegisterSuccessEmail.setText(mRegisterEmail);
    }

    @Override
    protected void initdata() {
        super.initdata();
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        String email = (String) savedInstanceState.get(RegisterActivity.REGESTER_EMAIL);
        mRegisterEmail = String.format(getResources().getString(R.string.register_email, email));
    }

    @OnClick(R.id.register_finish)
    public void onClick() {
       finish();
    }
}
