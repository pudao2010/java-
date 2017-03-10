package com.qhzk.ciep.ui.generalIntroduction.fragment;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.UnitList;
import com.qhzk.ciep.mvp.BasePresenter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/24.
 */

public class UnitListPresenter extends BasePresenter<UnitListView>{

    private int page = 1;

    public void getUnitList(int page, int rows){
        mApi.getUnitList(page, rows, new ResultSubscriber<List<UnitList>>(this) {
            @Override
            public void onSuccess(List<UnitList> unitLists) {
                getMvpView().onLoadSuccess(unitLists);
            }
        });
    }

    public void loadMore() {
        mApi.getUnitList(++page, 20, new ResultSubscriber<List<UnitList>>(this) {
            @Override
            public void onSuccess(List<UnitList> unitLists) {
                getMvpView().onLoadMore(unitLists);
            }
        });
    }
}
