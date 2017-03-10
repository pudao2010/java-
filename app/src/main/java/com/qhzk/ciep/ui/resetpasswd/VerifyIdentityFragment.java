package com.qhzk.ciep.ui.resetpasswd;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by  on 2016/11/8.
 * 找回密码,验证身份页面
 */

public class VerifyIdentityFragment extends BaseFragment<VerifyIdentityPresenter> implements VerifyIdentityView {

    @BindView(R.id.input_verify_code)
    EditText mInputVerifyCode;
    @BindView(R.id.btn_verify_code)
    Button mBtnVerifyCode;
    @BindView(R.id.btn_next)
    Button mBtnNext;
    @BindView(R.id.email)
    TextView mEmail;
    private Handler mHandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_verify_identity;
    }

    @OnClick({R.id.btn_verify_code, R.id.btn_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_verify_code:
                mFragmentPresenter.getEmailCode(mEmail.getText().toString().trim());
                break;
            case R.id.btn_next:
                //切换Fragment,进入设置新密码页面
                String code = mInputVerifyCode.getText().toString().trim();
                String userEmail = mEmail.getText().toString().trim();
                mFragmentPresenter.verifyEmailCode(userEmail, code);
                break;
        }
    }
    private int seconds = 60;
    @Override
    public void onResume() {
        mInputVerifyCode.setFocusable(true);
        mInputVerifyCode.setEnabled(true);
        mInputVerifyCode.requestFocus();
        mInputVerifyCode.setFocusableInTouchMode(true);
        super.onResume();
        if (mHandler != null) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mBtnVerifyCode.setText(--seconds + "秒后从新获取");
                    mHandler.postDelayed(this, 1000);

                    if (seconds==0){
                        mBtnVerifyCode.setEnabled(true);
                        mBtnVerifyCode.setBackgroundResource(R.drawable.frame_r_b_shape);
                        mBtnVerifyCode.setText("获取验证码");
                        mHandler.removeCallbacks(this);
                    }
                }
            }, 1000);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mHandler != null) {
            mHandler.removeCallbacks(null);
        }
        seconds = 60;
    }

    @Override
    protected void initdata() {
        super.initdata();
        ResetPasswdActivity activity = (ResetPasswdActivity) getActivity();
        String email = activity.mEmail;
        if (email != null) {
            mEmail.setText(email);
        }
    }

    @Override
    public void onLoadPhoneCodeSuccess() {

    }

    @Override
    public void onLoadPhoneCodeFailed() {
        showToast("获取验证码失败,请稍后再试");
    }

    @Override
    public void onCheckPhoneCodeSuccess() {

    }

    @Override
    public void onCheckPhoneCodeFailed(String msg) {
        showToast(msg);
    }

    @Override
    public void onSendEmailCodeSuccess() {
        showToast("验证码已发送至您的邮箱,请注意查收");
    }

    @Override
    public void onVerifyEmailCodeSuccess() {
        String code = mInputVerifyCode.getText().toString();
        ResetPasswdActivity activity = (ResetPasswdActivity) getActivity();
        activity.mCode = code;
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, new SetNewPasswordFragment());
        transaction.commit();
    }

    @Override
    public void onError(Exception e) {
        showToast("网络错误:"+ e);
    }

    @Override
    public void onVerifyEmailCodeFailed() {
        showToast("验证失败, 请稍后从新尝试");
    }
}
