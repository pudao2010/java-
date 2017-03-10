package com.qhzk.ciep.ui.unitinfo;

import com.qhzk.ciep.CiepApplication;
import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.config.Constant;
import com.qhzk.ciep.entity.EnterpriseBean;
import com.qhzk.ciep.entity.Focus;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.utils.SharedPrefUtil;

/**
 * Created by 蒲导
 * 单位信息 2016年12月26日10:17:37
 */

public class UnitInfoPresenter extends BasePresenter<UnitInfoView> {

    public void loadData(String id){
        mApi.getEnterpriseInfo(id, new ResultSubscriber<EnterpriseBean>(this) {
            @Override
            public void onSuccess(EnterpriseBean enterpriseBean) {
                getMvpView().onLoadSuccess(enterpriseBean);
            }
        });
    }

    public void addFocus(String entId){
        mApi.addFocus(entId, new ResultSubscriber<Void>(this) {
            @Override
            public void onSuccess(Void aVoid) {
                getMvpView().onAddFocusSuccess();
            }

            @Override
            protected void onError(String error) {
                String login_user = SharedPrefUtil.getPrefString(CiepApplication.getApplication(), Constant.LOGIN_USER, "");
                String login_password = SharedPrefUtil.getPrefString(CiepApplication.getApplication(), Constant.LOGIN_PASSWORD, "");
                if (!login_user.equals("")&&!login_password.equals("")){
                    mApi.login(login_user, login_password, new ResultSubscriber<Void>(UnitInfoPresenter.this) {
                        @Override
                        public void onSuccess(Void aVoid) {
                            addFocus(entId);
                        }

                        @Override
                        protected void onError(String error) {
                            getMvpView().onAddFocusFailed(error);
                        }
                    });
                }else {
                    getMvpView().onAddFocusFailed("需要重新登录才能完成此操作");
                }
            }
        });
    }

    public void cancelFocus(String entId){
        mApi.cancelFocus(entId, new ResultSubscriber<Void>(this) {
            @Override
            public void onSuccess(Void aVoid) {
                getMvpView().onCancelFocusSuccess();
            }

            @Override
            protected void onError(String error) {
                String login_user = SharedPrefUtil.getPrefString(CiepApplication.getApplication(), Constant.LOGIN_USER, "");
                String login_password = SharedPrefUtil.getPrefString(CiepApplication.getApplication(), Constant.LOGIN_PASSWORD, "");
                if (!login_user.equals("")&&!login_password.equals("")){
                    mApi.login(login_user, login_password, new ResultSubscriber<Void>(UnitInfoPresenter.this) {
                        @Override
                        public void onSuccess(Void aVoid) {
                            cancelFocus(entId);
                        }

                        @Override
                        protected void onError(String error) {
                            getMvpView().onCancelFocusFailed(error);
                        }
                    });
                }else {
                    getMvpView().onAddFocusFailed("需要重新登录才能完成此操作");
                }
            }
        });
    }

    public void checkFocus(String entId){
        mApi.checkFocus(entId, new ResultSubscriber<Focus>(this) {
            @Override
            public void onSuccess(Focus focus) {
                if (focus.isFocused()){
                    getMvpView().onCheckFocusResult(true);
                }else{
                    getMvpView().onCheckFocusResult(false);
                }
            }

            @Override
            protected void onError(String error) {
                String login_user = SharedPrefUtil.getPrefString(CiepApplication.getApplication(), Constant.LOGIN_USER, "");
                String login_password = SharedPrefUtil.getPrefString(CiepApplication.getApplication(), Constant.LOGIN_PASSWORD, "");
                if (!login_user.equals("")&&!login_password.equals("")){
                    mApi.login(login_user, login_password, new ResultSubscriber<Void>(UnitInfoPresenter.this) {
                        @Override
                        public void onSuccess(Void aVoid) {
                            checkFocus(entId);
                        }

                        @Override
                        protected void onError(String error) {
                            getMvpView().onCheckFocusResult(false);
                        }
                    });
                }else {
                    getMvpView().onCheckFocusResult(false);
                }
            }
        });
    }
}
