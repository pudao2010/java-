package com.qhzk.ciep.ui.mine.setting.updatepassword;

import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/20.
 */

public interface UpdatePasswordView extends MvpView{

    void showProgress();

    void hideProgress();

    void showInputError();

    void onUpdateSuccess();

    void onUpdateFailed();
}
