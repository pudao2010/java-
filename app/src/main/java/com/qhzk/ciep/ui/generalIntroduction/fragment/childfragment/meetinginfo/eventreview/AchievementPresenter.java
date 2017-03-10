package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.eventreview;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.AchieveMent;
import com.qhzk.ciep.mvp.BasePresenter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/24.
 */

public class AchievementPresenter extends BasePresenter<AchievementView> {
    private int page = 1;
    public void loadData(int page, int rows){
        mApi.getAchievements(page, rows, new ResultSubscriber<List<AchieveMent>>(this) {
            @Override
            public void onSuccess(List<AchieveMent> list) {
                getMvpView().onLoadSuccess(list);
            }
        });
    }

    public void loadMore() {
        mApi.getAchievements(++page, 20, new ResultSubscriber<List<AchieveMent>>(this) {
            @Override
            public void onSuccess(List<AchieveMent> list) {
                getMvpView().onLoadMore(list);
            }
        });
    }
}
