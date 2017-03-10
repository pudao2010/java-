package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo;

import com.qhzk.ciep.entity.NewsDetail;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/15.
 */

public interface MeetingInfoView extends MvpView{

    void onLoadSuccess(NewsDetail newsDetail);
}
