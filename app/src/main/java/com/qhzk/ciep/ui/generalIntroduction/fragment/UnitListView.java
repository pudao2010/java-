package com.qhzk.ciep.ui.generalIntroduction.fragment;

import com.qhzk.ciep.entity.UnitList;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/24.
 */

public interface UnitListView extends MvpView{

    void onLoadSuccess(List<UnitList> unitLists);

    void onLoadMore(List<UnitList> unitLists);
}
