package com.qhzk.ciep.ui.resetpasswd;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;
import android.widget.EditText;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;
import com.qhzk.ciep.config.Constant;
import com.qhzk.ciep.utils.SharedPrefUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/14.
 * 设置新密码
 */

public class SetNewPasswordFragment extends BaseFragment<SetNewPasswordPresenter> implements SetNewPasswordView {

    @BindView(R.id.et_new_password)
    EditText mEtNewPassword;
    @BindView(R.id.et_confirm_password)
    EditText mEtConfirmPassword;
    @BindView(R.id.btn_commit)
    Button mBtnCommit;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_set_newpasswd;
    }

    @OnClick(R.id.btn_commit)
    public void onClick() {
        ResetPasswdActivity activity = (ResetPasswdActivity) getActivity();

        if (!mEtNewPassword.getText().toString().trim().equals("")){
            if (mEtNewPassword.getText().toString().trim().equals(mEtConfirmPassword.getText().toString().trim())){
                String passwordnew = mEtNewPassword.getText().toString().trim();
                mFragmentPresenter.changePassword(activity.mEmail, activity.mCode, passwordnew);
            }else{
                showToast("两次输入的密码不一致");
            }
        }else{
            showToast("请输入密码");
        }

    }

    @Override
    public void onChangePasswordSuccess() {
        showToast("密码已经修改");
        SharedPrefUtil.savePrefString(this.getContext(), Constant.LOGIN_PASSWORD, mEtConfirmPassword.getText().toString());
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, new UpdatePasswordSuccessFragment());
        transaction.commit();
    }

    @Override
    public void onChangePasswordFailed() {
        showToast("修改密码失败, 请稍后再试");
    }

    @Override
    public void onError(Exception e) {
        showToast("网络异常:"+e);
    }

}
