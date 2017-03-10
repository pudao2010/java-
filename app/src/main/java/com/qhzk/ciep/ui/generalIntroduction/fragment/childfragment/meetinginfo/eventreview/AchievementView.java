package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.eventreview;

import com.qhzk.ciep.entity.AchieveMent;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/24.
 */

public interface AchievementView extends MvpView{

    void onLoadSuccess(List<AchieveMent> list);

    void onLoadMore(List<AchieveMent> list);
}
