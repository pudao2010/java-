package com.qhzk.ciep.ui.mine.setting.updatepassword;

import android.app.ProgressDialog;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.config.Constant;
import com.qhzk.ciep.utils.SharedPrefUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 修改密码 2016年12月20日10:31:29
 */
public class UpdatePasswordActivity extends BaseActivity<UpdatePasswordPresenter> implements UpdatePasswordView {

    private ProgressDialog mProgressDialog;
    @BindView(R.id.old_password)
    EditText mOldPassword;
    @BindView(R.id.new_password)
    EditText mNewPassword;
    @BindView(R.id.btn_finish)
    Button mBtnFinish;

    private boolean flag = false; //密码可见与不可见的标记

    @Override
    public int getLayoutId() {
        return R.layout.activity_update_password;
    }

    @Override
    protected void initview() {
        super.initview();
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    public void showProgress() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("正在提交");
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
    public void showInputError() {
        showToast("密码不能为空");
    }

    @Override
    public void onUpdateSuccess() {
        showToast("密码修改成功");
        SharedPrefUtil.savePrefString(this, Constant.LOGIN_PASSWORD, mNewPassword.getText().toString());
        finish();
    }

    @Override
    public void onUpdateFailed() {
        showToast("密码修改失败");
    }

    @OnClick({R.id.toggle_texttype, R.id.btn_finish})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toggle_texttype:
                if (flag){
                    mNewPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    flag = false;
                }else{
                    mNewPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    flag = true;
                }
                break;
            case R.id.btn_finish:
                String password = mOldPassword.getText().toString().trim();
                String passwordnew = mNewPassword.getText().toString().trim();
                mActivityPresenter.updatePasswprd(password, passwordnew);
                break;
        }
    }
}
