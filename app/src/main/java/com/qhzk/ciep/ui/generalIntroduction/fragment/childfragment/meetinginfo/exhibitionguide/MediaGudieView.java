package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.exhibitionguide;

import com.qhzk.ciep.entity.NewsDetail;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/18.
 */

public interface MediaGudieView extends MvpView {

    void onLoadSuccess(NewsDetail newsDetail);

}
