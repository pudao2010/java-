package com.qhzk.ciep.ui.mine.setting;

import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/20.
 */

public interface SettingView extends MvpView{

    void showProgress();

    void hideProgress();

    void onLogoutSuccess();

    void onLogoutFailed();
}
