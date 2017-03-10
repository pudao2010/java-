package com.qhzk.ciep.ui.search.news;

import com.qhzk.ciep.entity.SearchNewEntity;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by QixiongYuan on 2016/12/8.
 */

public interface NewsView extends MvpView {

    void onNewItemResult(List<SearchNewEntity.NewsBean.RowsBean> list);

}
