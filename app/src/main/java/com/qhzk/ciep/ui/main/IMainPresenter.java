package com.qhzk.ciep.ui.main;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.protocol.CiepProtocol;
import com.qhzk.ciep.protocol.JpushIDProtocol;

import okhttp3.Call;

/**
 * Created by pucheng on 2017/1/3.
 */

public class IMainPresenter extends BasePresenter<IMainView> {

    public void login(String username, String password){
        mApi.login(username, password, new ResultSubscriber<Void>(this) {
            @Override
            public void onSuccess(Void aVoid) {
                getMvpView().onLoginSuccess();
            }
        });
    }

    public void commitJpushId(String registrationID) {
        JpushIDProtocol protocol = new JpushIDProtocol(new CiepProtocol.Callback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                getMvpView().onError(e);
            }

            @Override
            public void onSuccess() {
                getMvpView().onCommitJpushIDSuccess();
            }

            @Override
            public void onFailed() {
                getMvpView().onCommitJpushIdFailed();
            }
        });
        protocol.setRegistrationId(registrationID);
        protocol.uploadDataByPost();
    }
}
