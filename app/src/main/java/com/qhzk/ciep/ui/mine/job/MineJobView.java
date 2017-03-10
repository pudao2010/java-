package com.qhzk.ciep.ui.mine.job;

import com.qhzk.ciep.entity.Deliver;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */

public interface MineJobView extends MvpView{

    void onLoadSuccess(List<Deliver> list);

    void onLoadMore(List<Deliver> list);

    void onError(Exception e);

    void onCancelSuccess();

    void onCancelFailed();
}
