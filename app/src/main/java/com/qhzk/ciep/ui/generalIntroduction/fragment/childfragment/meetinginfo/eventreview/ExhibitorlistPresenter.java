package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.eventreview;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.Exhibitor;
import com.qhzk.ciep.mvp.BasePresenter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/24.
 */

public class ExhibitorlistPresenter extends BasePresenter<ExhibitorlistView> {

    private int page = 1;
    public void loadData(int page, int rows){
        mApi.getExhibitorList(page, rows, new ResultSubscriber<List<Exhibitor>>(this) {
            @Override
            public void onSuccess(List<Exhibitor> exhibitors) {
                System.out.println(exhibitors);
                getMvpView().onLoadSuccess(exhibitors);
            }
        });
    }

    public void loadMore() {
        mApi.getExhibitorList(++page, 20, new ResultSubscriber<List<Exhibitor>>(this) {
            @Override
            public void onSuccess(List<Exhibitor> exhibitors) {
                System.out.println(exhibitors);
                getMvpView().onLoadMore(exhibitors);
            }
        });
    }
}
