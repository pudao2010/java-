package com.qhzk.ciep.ui.tickets;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.UserInfo;
import com.qhzk.ciep.mvp.BasePresenter;

/**
 * Created by Administrator on 2016/12/24.
 */

public class TicketsPresenter extends BasePresenter<TicketsView> {

    public void getUserInfo(){
        mApi.getUserInfo(new ResultSubscriber<UserInfo>(this) {
            @Override
            public void onSuccess(UserInfo userInfo) {
                getMvpView().onLoadUserInfoSuccess(userInfo);
            }
        });
    }
}
