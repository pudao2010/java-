package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.activity;

import com.qhzk.ciep.entity.NewsDetail;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/16.
 */

public interface ActivityView extends MvpView {

    void onLoadSuccess(NewsDetail newsDetail);
}
