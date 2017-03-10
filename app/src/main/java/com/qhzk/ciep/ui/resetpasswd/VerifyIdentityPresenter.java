package com.qhzk.ciep.ui.resetpasswd;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.protocol.CiepProtocol;
import com.qhzk.ciep.protocol.EmailCodeProtocol;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/25.
 */

public class VerifyIdentityPresenter extends BasePresenter<VerifyIdentityView>{

    public void getPhoneCode(String mobile){
        mApi.getPhoneCode(mobile, new ResultSubscriber<Void>(this) {
            @Override
            public void onSuccess(Void aVoid) {
                getMvpView().onLoadPhoneCodeSuccess();
            }

            @Override
            protected void onError(String error) {
                getMvpView().onLoadPhoneCodeFailed();
            }
        });
    }

    public void checkMobilecode(String mobcode, String mobilePhone) {
        mApi.checkPhoneCode(mobcode, mobilePhone, new ResultSubscriber<Void>(this) {
            @Override
            public void onSuccess(Void aVoid) {
                getMvpView().onCheckPhoneCodeSuccess();
            }

            @Override
            protected void onError(String error) {
                getMvpView().onCheckPhoneCodeFailed(error);
            }
        });
    }

    public void getEmailCode(String email){
        mApi.getEmailCode(email, new ResultSubscriber<Void>(this) {
            @Override
            public void onSuccess(Void aVoid) {
                getMvpView().onSendEmailCodeSuccess();
            }
        });
    }

    public void verifyEmailCode(String userEmail, String code) {
        EmailCodeProtocol protocol = new EmailCodeProtocol(new CiepProtocol.Callback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                getMvpView().onError(e);
            }

            @Override
            public void onSuccess() {
                getMvpView().onVerifyEmailCodeSuccess();
            }

            @Override
            public void onFailed() {
                getMvpView().onVerifyEmailCodeFailed();
            }
        });
        protocol.setUserEmail(userEmail);
        protocol.setCode(code);
        protocol.uploadDataByPost();
    }
}
