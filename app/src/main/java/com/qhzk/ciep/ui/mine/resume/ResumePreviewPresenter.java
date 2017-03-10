package com.qhzk.ciep.ui.mine.resume;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.UserInfo;
import com.qhzk.ciep.mvp.BasePresenter;

/**
 * Created by Administrator on 2016/12/28.
 */

public class ResumePreviewPresenter extends BasePresenter<ResumePreviewView> {

    public void getUserInfo(){
        mApi.getUserInfo(new ResultSubscriber<UserInfo>(this) {
            @Override
            public void onSuccess(UserInfo userInfo) {
                if (userInfo != null) {
                    getMvpView().onLoadUserInfoSuccess(userInfo);
                }

            }
        });
    }
}
