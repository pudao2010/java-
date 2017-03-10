package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.commend;

import com.qhzk.ciep.entity.NewsDetail;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/16.
 */

public interface CommendView extends MvpView {

    void onLoadSuccess(NewsDetail newsDetail);
}
