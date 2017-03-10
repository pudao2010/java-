package com.qhzk.ciep.ui.resetpasswd;

import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.protocol.CiepProtocol;
import com.qhzk.ciep.protocol.SetNewpasswordProtocol;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/25.
 */

public class SetNewPasswordPresenter extends BasePresenter<SetNewPasswordView> {

    public void changePassword(String userEmail, String code, String password){

        SetNewpasswordProtocol protocol = new SetNewpasswordProtocol(new CiepProtocol.Callback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                getMvpView().onError(e);
            }

            @Override
            public void onSuccess() {
                getMvpView().onChangePasswordSuccess();
            }

            @Override
            public void onFailed() {
                getMvpView().onChangePasswordFailed();
            }
        });
        protocol.setCode(code);
        protocol.setUserEmail(userEmail);
        protocol.setPassword(password);
        protocol.uploadDataByPost();
    }
}
