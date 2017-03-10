package com.qhzk.ciep.ui.talentdock;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.UnitInfoEntity;
import com.qhzk.ciep.mvp.BasePresenter;

/**
 * Created by Administrator on 2016/12/29.
 */

public class TalentDockPresenter extends BasePresenter<TalentDockView> {

    private int page = 1;
    public void loadData(int page, int rows){
        getMvpView().showProgress();
        mApi.getUnitInfos(page, rows, new ResultSubscriber<UnitInfoEntity>(this) {
            @Override
            public void onSuccess(UnitInfoEntity unitInfoEntity) {
                getMvpView().hideProgress();
                getMvpView().onLoadSuccess(unitInfoEntity);
            }
        });
    }

    public void loadMore() {
        getMvpView().showProgress();
        mApi.getUnitInfos(++page, 20, new ResultSubscriber<UnitInfoEntity>(this) {
            @Override
            public void onSuccess(UnitInfoEntity unitInfoEntity) {
                getMvpView().hideProgress();
                getMvpView().onLoadMore(unitInfoEntity);
            }
        });
    }

    public void fiterJob(int page, int rows, String title, String entName, String salRange, String experience,
                         String education, String major, String industry, String jobType){
        getMvpView().showProgress();
        mApi.getSearchJob(page, rows, title, entName, salRange, experience, education, major, industry, jobType, new ResultSubscriber<UnitInfoEntity>(this) {
            @Override
            public void onSuccess(UnitInfoEntity unitInfoEntity) {
                if (unitInfoEntity.getResult().size()>0){
                    getMvpView().hideProgress();
                    getMvpView().onFilterSuccess(unitInfoEntity);
                }else{
                    getMvpView().hideProgress();
                    getMvpView().onFilterFailed(unitInfoEntity);
                }
            }
        });
    }
}
