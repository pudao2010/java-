package com.qhzk.ciep.ui.plateinfo;

import com.qhzk.ciep.entity.PlateDetail;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/19.
 * 2016年12月19日22:45:09
 */

public interface PlateInfoView extends MvpView{

    void onLoadSuccess(PlateDetail plateDetail);
}
