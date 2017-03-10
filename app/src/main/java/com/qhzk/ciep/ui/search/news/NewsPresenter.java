package com.qhzk.ciep.ui.search.news;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.NewEntity;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.ui.home.HomeFragment;
import com.qhzk.ciep.utils.ServiceUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thisdk on 2016/9/1.
 */

public class NewsPresenter extends BasePresenter<NewsView> {


    public void getNewItemData() {
        mApi.getNews(1, 10, "newscenter", new ResultSubscriber<List<NewEntity>>(this) {
            @Override
            public void onSuccess(List<NewEntity> newEntities) {
                if (newEntities == null) return;
                List<HomeFragment.NewItem> list = new ArrayList<HomeFragment.NewItem>();
                for (NewEntity news : newEntities) {
                    list.add(new HomeFragment.NewItem(ServiceUtil.subImageUrl(news.getPcimg())
                            , news.getTitle()
                            , news.getCreatetime()
                    ));
                }
//                getMvpView().onNewItemResult(list);
            }
        });
    }

}
