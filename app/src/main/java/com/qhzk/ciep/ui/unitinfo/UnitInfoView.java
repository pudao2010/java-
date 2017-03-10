package com.qhzk.ciep.ui.unitinfo;

import com.qhzk.ciep.entity.EnterpriseBean;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/26.
 */

public interface UnitInfoView extends MvpView{

    void onLoadSuccess(EnterpriseBean enterpriseBean);

    void onAddFocusSuccess();

    void onAddFocusFailed(String error);

    void onCancelFocusSuccess();

    void onCancelFocusFailed(String error);

    void onCheckFocusResult(boolean b);
}
