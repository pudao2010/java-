package com.qhzk.ciep.ui.talentdock;

import com.qhzk.ciep.entity.UnitInfoEntity;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/29.
 */

public interface TalentDockView extends MvpView{

    void showProgress();

    void hideProgress();

    void onLoadSuccess(UnitInfoEntity unitInfoEntity);

    void onLoadMore(UnitInfoEntity unitInfoEntity);

    void onFilterSuccess(UnitInfoEntity searchJob);

    void onFilterFailed(UnitInfoEntity searchJob);
}
