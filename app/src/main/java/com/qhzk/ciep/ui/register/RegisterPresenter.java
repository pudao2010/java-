package com.qhzk.ciep.ui.register;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.mvp.BasePresenter;


/**
 * Created by Administrator on 2016/12/13.
 */

public class RegisterPresenter extends BasePresenter<RegisterView> {

    public void register(String custtype, String custname, String password ,String passconfirm){
        mApi.register(custtype, custname, password, passconfirm, new ResultSubscriber<Void>(this) {
            @Override
            public void onSuccess(Void aVoid) {
                getMvpView().onRegisterSuccess();
            }
        });
    }
}
