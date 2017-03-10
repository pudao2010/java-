package com.qhzk.ciep.ui.login;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.protocol.CheckProtocol;
import com.qhzk.ciep.protocol.CiepProtocol;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/13.
 *
 */

public class LoginPresenter extends BasePresenter<LoginView>{

    public void login(String usercode, String password){
        mApi.login(usercode, password, new ResultSubscriber<Void>(this) {
            @Override
            public void onSuccess(Void aVoid) {
                getMvpView().onLoginSuccess(usercode, password);
            }

            @Override
            protected void onError(String error) {
                super.onError(error);
                getMvpView().onLoginFailed();
            }
        });
    }

    public void checkPersonOrNot(String username){
//        mApi.checkPersonOrNot(username, new ResultSubscriber<Void>(this) {
//            @Override
//            public void onSuccess(Void aVoid) {
//                getMvpView().onCheckSuccess();
//            }
//        });

        CheckProtocol protocol = new CheckProtocol(new CiepProtocol.Callback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                getMvpView().onError(e);
            }

            @Override
            public void onSuccess() {
                getMvpView().onCheckSuccess();
            }

            @Override
            public void onFailed() {
                getMvpView().onFailed();
            }
        });
        protocol.setUserCode(username);
        protocol.uploadDataByPost();
    }
}
