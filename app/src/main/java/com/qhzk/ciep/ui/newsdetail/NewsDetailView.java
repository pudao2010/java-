package com.qhzk.ciep.ui.newsdetail;

import com.qhzk.ciep.entity.NewsDetail;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/15.
 */

public interface NewsDetailView extends MvpView {

    void loadSuccess(NewsDetail newsDetail);

}
