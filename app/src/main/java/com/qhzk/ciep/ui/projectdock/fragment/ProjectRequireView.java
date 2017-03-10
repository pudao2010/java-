package com.qhzk.ciep.ui.projectdock.fragment;

import com.qhzk.ciep.entity.ProjectRequireEntity;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */

public interface ProjectRequireView extends MvpView{

    void onLoadSuccess(List<ProjectRequireEntity> list);

    void onFilterSuccess(List<ProjectRequireEntity> list);

    void onFilterFailed(List<ProjectRequireEntity> list);

    void showProgress();

    void hideProgress();

    void onLoadMore(List<ProjectRequireEntity> list);
}
