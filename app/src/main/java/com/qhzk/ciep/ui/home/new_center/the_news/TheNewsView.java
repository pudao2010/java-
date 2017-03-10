package com.qhzk.ciep.ui.home.new_center.the_news;

import com.qhzk.ciep.entity.NewEntity;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 *
 */

public interface TheNewsView extends MvpView{

    void onConfNewsResult(List<NewEntity> list);

    void onConfNewsResultMore(List<NewEntity> list);

    void onConfNewsResultNoMore(List<NewEntity> list);
}
