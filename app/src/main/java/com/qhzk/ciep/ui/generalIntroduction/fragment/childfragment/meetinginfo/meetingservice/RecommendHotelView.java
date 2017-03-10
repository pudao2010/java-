package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.meetingservice;

import com.qhzk.ciep.entity.NewsDetail;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/18.
 */

public interface RecommendHotelView extends MvpView{

    void onLoadSuccess(NewsDetail newsDetail);
}
