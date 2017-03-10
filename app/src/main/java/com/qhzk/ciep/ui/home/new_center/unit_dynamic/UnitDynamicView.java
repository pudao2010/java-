package com.qhzk.ciep.ui.home.new_center.unit_dynamic;

import com.qhzk.ciep.entity.NewEntity;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */

public interface UnitDynamicView extends MvpView {

    void onUnitDynamicResult(List<NewEntity> list);

    void onLoadMore(List<NewEntity> list);

    void onLoadNoMore(List<NewEntity> list);
}
