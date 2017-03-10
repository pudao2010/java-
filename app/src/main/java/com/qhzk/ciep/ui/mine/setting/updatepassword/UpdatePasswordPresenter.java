package com.qhzk.ciep.ui.mine.setting.updatepassword;

import android.text.TextUtils;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.mvp.BasePresenter;

/**
 * Created by Administrator on 2016/12/20.
 */

public class UpdatePasswordPresenter extends BasePresenter<UpdatePasswordView> {

    public void updatePasswprd(String password, String passwordnew){
        if (!TextUtils.isEmpty(password) && !TextUtils.isEmpty(passwordnew)){
            getMvpView().showProgress();

            mApi.updatePassword(password, passwordnew, new ResultSubscriber<Void>(this) {
                @Override
                public void onSuccess(Void aVoid) {
                    getMvpView().hideProgress();
                    getMvpView().onUpdateSuccess();
                }

                @Override
                protected void onError(String error) {
                    super.onError(error);
                    getMvpView().hideProgress();
                    getMvpView().onUpdateFailed();
                }
            });
        }else{
            getMvpView().showInputError();
        }

    }
}
