package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.forum;

import com.qhzk.ciep.entity.ForumAgenda;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by pucheng on 2017/2/15.
 *
 */

public interface ForumAgendaView extends MvpView {


    void onLoadSuccess(List<ForumAgenda> forumAgendas);

    void onLoadMore(List<ForumAgenda> forumAgendas);
}
