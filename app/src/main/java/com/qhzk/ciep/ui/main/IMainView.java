package com.qhzk.ciep.ui.main;

import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by pucheng on 2017/1/3.
 */

public interface IMainView extends MvpView{
    void onLoginSuccess();

    void onCommitJpushIDSuccess();

    void onCommitJpushIdFailed();

    void onError(Exception e);
}
