package com.qhzk.ciep.ui.resetpasswd;

import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/25.
 */

public interface SetNewPasswordView extends MvpView{

    void onChangePasswordSuccess();

    void onChangePasswordFailed();

    void onError(Exception e);
}
