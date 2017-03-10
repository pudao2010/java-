package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.forum;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.ForumAgenda;
import com.qhzk.ciep.mvp.BasePresenter;

import java.util.List;

/**
 * Created by pucheng on 2017/2/15.
 *
 */

public class ForumAgendaPresenter extends BasePresenter<ForumAgendaView> {

    public int page = 1;

    public void loadData(int page, int rows){
        mApi.getForumAgenda(page, rows, new ResultSubscriber<List<ForumAgenda>>(this) {
            @Override
            public void onSuccess(List<ForumAgenda> forumAgendas) {
                getMvpView().onLoadSuccess(forumAgendas);
            }
        });
    }

    public void loadMore(){
        mApi.getForumAgenda(++page, 20, new ResultSubscriber<List<ForumAgenda>>(this) {
            @Override
            public void onSuccess(List<ForumAgenda> forumAgendas) {
                getMvpView().onLoadMore(forumAgendas);
            }
        });
    }
}
