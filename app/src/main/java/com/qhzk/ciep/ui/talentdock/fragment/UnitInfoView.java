package com.qhzk.ciep.ui.talentdock.fragment;

import com.qhzk.ciep.entity.UnitInfoEntity;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/23.
 */

public interface UnitInfoView extends MvpView {

    void onLoadSuccess(UnitInfoEntity unitInfoEntity);

    void onLoadMore(UnitInfoEntity unitInfoEntity);
}
