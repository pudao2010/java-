package com.qhzk.ciep.ui.generalIntroduction.fragment.childfragment.meetinginfo.forum;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.NewsDetail;
import com.qhzk.ciep.mvp.BasePresenter;

/**
 * Created by Administrator on 2016/12/16.
 */

public class ForumInfoPresenter extends BasePresenter<ForumInfoView> {

    public void loadData(String typecode){
        mApi.getByTypecodeinfo(typecode, new ResultSubscriber<NewsDetail>(this) {
            @Override
            public void onSuccess(NewsDetail newsDetail) {
                if (newsDetail != null){
                    getMvpView().onLoadSuccess(newsDetail);
                }
            }
        });
    }
}
