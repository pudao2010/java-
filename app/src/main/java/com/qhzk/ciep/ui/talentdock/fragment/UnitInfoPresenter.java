package com.qhzk.ciep.ui.talentdock.fragment;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.UnitInfoEntity;
import com.qhzk.ciep.mvp.BasePresenter;

/**
 * Created by Administrator on 2016/12/23.
 */

public class UnitInfoPresenter extends BasePresenter<UnitInfoView>{
    private int page = 1;
    public void loadData(int page, int rows){
        mApi.getUnitInfos(page, rows, new ResultSubscriber<UnitInfoEntity>(this) {
            @Override
            public void onSuccess(UnitInfoEntity unitInfoEntity) {
                getMvpView().onLoadSuccess(unitInfoEntity);
            }
        });
    }

    public void loadMore() {
        mApi.getUnitInfos(++page, 20, new ResultSubscriber<UnitInfoEntity>(this) {
            @Override
            public void onSuccess(UnitInfoEntity unitInfoEntity) {
                getMvpView().onLoadMore(unitInfoEntity);
            }
        });
    }
}
