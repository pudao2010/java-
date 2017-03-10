package com.qhzk.ciep.ui.unitinfo;

import com.qhzk.ciep.entity.UnitInfoTalent;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/26.
 */

public interface UnitInfoTalentDockView extends MvpView{

    void onLoadSuccess(List<UnitInfoTalent.DataBean.PositionsBean.ResultBean> list);

    void onLoadMore(List<UnitInfoTalent.DataBean.PositionsBean.ResultBean> list);

    void onError(Exception e);
}
