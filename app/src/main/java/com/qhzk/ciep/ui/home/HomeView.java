package com.qhzk.ciep.ui.home;

import com.qhzk.ciep.entity.NewEntity;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by Thisdk on 2016/9/1.
 */

public interface HomeView extends MvpView {

    void onBannerResult(List<String> list);

    void onMarqueesResult(List<String> list);

    void onNewItemResult(List<HomeFragment.NewItem> list);

    void onNewItemResults(List<NewEntity> list);

    void onCheckIsAttend(boolean isAttend);
}
