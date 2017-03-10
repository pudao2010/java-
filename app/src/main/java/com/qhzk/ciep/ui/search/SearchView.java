package com.qhzk.ciep.ui.search;

import com.qhzk.ciep.entity.SearchNewEntity;
import com.qhzk.ciep.entity.SearchUnitEntity;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/30.
 */

public interface SearchView extends MvpView{

    void onSearchNewSuccess(List<SearchNewEntity.NewsBean.RowsBean> rows);

    void onSearchNewFailed(List<SearchNewEntity.NewsBean.RowsBean> rows);

    void onError(Exception e);

    void onSearchUnitSuccess(List<SearchUnitEntity.EnterpriseBean.RowsBean> rows);

    void onSearchUnitFailed(List<SearchUnitEntity.EnterpriseBean.RowsBean> rows);
}
