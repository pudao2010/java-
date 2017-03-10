package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.eventreview;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.NewVideoEntity;
import com.qhzk.ciep.mvp.BasePresenter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/24.
 */

public class RelateVideoPresenter extends BasePresenter<RelateVideoView>{
    private int page;
    public void loadData(int page, int rows) {
        mApi.getVideoList(page, rows, new ResultSubscriber<List<NewVideoEntity>>(this) {
            @Override
            public void onSuccess(List<NewVideoEntity> list) {
                getMvpView().onLoadSuccess(list);
            }
        });
    }

    public void loadMore() {
        mApi.getVideoList(++page, 20, new ResultSubscriber<List<NewVideoEntity>>(this) {
            @Override
            public void onSuccess(List<NewVideoEntity> list) {
                getMvpView().onLoadMore(list);
            }
        });
    }
}
