package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.boothbuild;

import com.qhzk.ciep.entity.NewsDetail;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/18.
 */

public interface BoothbuildView extends MvpView{

    void onLoadSuccess(NewsDetail newsDetail);
}
