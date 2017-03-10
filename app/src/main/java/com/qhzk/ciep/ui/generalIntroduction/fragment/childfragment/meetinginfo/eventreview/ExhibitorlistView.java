package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.eventreview;

import com.qhzk.ciep.entity.Exhibitor;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/24.
 */

public interface ExhibitorlistView extends MvpView{

    void onLoadSuccess(List<Exhibitor> exhibitors);

    void onLoadMore(List<Exhibitor> exhibitors);
}
