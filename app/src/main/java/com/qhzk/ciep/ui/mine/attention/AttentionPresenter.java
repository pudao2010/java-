package com.qhzk.ciep.ui.mine.attention;

import com.qhzk.ciep.CiepApplication;
import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.config.Constant;
import com.qhzk.ciep.entity.MyFocus;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.utils.SharedPrefUtil;

/**
 * Created by Administrator on 2016/12/26.
 */

public class AttentionPresenter extends BasePresenter<AttentionView> {

    public void loadData(){
        mApi.getMyFocus(new ResultSubscriber<MyFocus>(this) {
            @Override
            public void onSuccess(MyFocus myFocus) {
                if (myFocus.getResult().size() > 0) {
                    getMvpView().onLoadSuccess(myFocus);
                }else {
                    getMvpView().onLoadNodata();
                }

            }

            @Override
            protected void onError(String error) {
                //重新登录
                String username = SharedPrefUtil.getPrefString(CiepApplication.getApplication(), Constant.LOGIN_USER, "");
                String password = SharedPrefUtil.getPrefString(CiepApplication.getApplication(), Constant.LOGIN_PASSWORD, "");
                mApi.login(username, password, new ResultSubscriber<Void>(AttentionPresenter.this) {
                    @Override
                    public void onSuccess(Void aVoid) {
                        loadData();
                    }
                });
            }
        });
    }

}
