package com.qhzk.ciep.ui.resetpasswd;

import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/25.
 */

public interface VerifyIdentityView extends MvpView{

    void onLoadPhoneCodeSuccess();

    void onLoadPhoneCodeFailed();

    void onCheckPhoneCodeSuccess();

    void onCheckPhoneCodeFailed(String msg);

    void onSendEmailCodeSuccess();

    void onVerifyEmailCodeSuccess();

    void onError(Exception e);

    void onVerifyEmailCodeFailed();
}
