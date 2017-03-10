package com.qhzk.ciep.ui.mine.setting;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.mvp.BasePresenter;

/**
 * Created by Administrator on 2016/12/20.
 */

public class SettingPresenter extends BasePresenter<SettingView> {

    public void logout(){
        getMvpView().showProgress();
        mApi.logout(new ResultSubscriber<Void>(this) {
            @Override
            public void onSuccess(Void aVoid) {
                getMvpView().hideProgress();
                getMvpView().onLogoutSuccess();
            }

            @Override
            protected void onError(String error) {
                super.onError(error);
                getMvpView().hideProgress();
                getMvpView().onLogoutFailed();
            }
        });
    }
}
