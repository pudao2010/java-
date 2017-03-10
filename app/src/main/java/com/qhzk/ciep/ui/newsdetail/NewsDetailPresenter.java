package com.qhzk.ciep.ui.newsdetail;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.NewsDetail;
import com.qhzk.ciep.mvp.BasePresenter;

/**
 * Created by Administrtor on 2016/12/15.
 */

public class NewsDetailPresenter extends BasePresenter<NewsDetailView> {

    public void loadNewsDetail(String id) {
        mApi.getByidinfo(id, new ResultSubscriber<NewsDetail>(this) {
            @Override
            public void onSuccess(NewsDetail newsDetail) {
                getMvpView().loadSuccess(newsDetail);
            }
        });
    }

}
