package com.qhzk.ciep.ui.home.attend.plate;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.mvp.BasePresenter;

/**
 * Created by Administrator on 2016/12/23.
 */

public class SelPlatePresenter extends BasePresenter<SelPlateView> {

    public void commit(String confIds){
        mApi.commitMeetings(confIds, new ResultSubscriber<Void>(this) {
            @Override
            public void onSuccess(Void aVoid) {
                getMvpView().onCommitSuccess();
            }

            /*@Override
            protected void onError(String error) {
//                super.onError(error);
                //打补丁的方式,再次登录
                System.out.println("错误产生了 ======="+error);
                String username = SharedPrefUtil.getPrefString(CiepApplication.getApplication(), Constant.LOGIN_USER, "");
                String password = SharedPrefUtil.getPrefString(CiepApplication.getApplication(), Constant.LOGIN_PASSWORD, "");
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)){
                    mApi.login(username, password, new ResultSubscriber<Void>(SelPlatePresenter.this) {
                        @Override
                        public void onSuccess(Void aVoid) {
                            commit(confIds);
                        }
                    });
                }
            }*/
        });
    }
}
