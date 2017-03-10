package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.agenda;

import com.qhzk.ciep.entity.NewsDetail;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/16.
 */

public interface AgendaView extends MvpView {

    void onLoadSuccess(NewsDetail newsDetail);
}
