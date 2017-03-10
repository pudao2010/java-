package com.qhzk.ciep.ui.login;

import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by pucheng on 2016/12/13.
 * LoginView
 */

public interface LoginView extends MvpView {

    void onLoginSuccess(String usercode, String password);

    void onLoginFailed();

    void onCheckSuccess();

    void onError(Exception e);

    void onFailed();
}
