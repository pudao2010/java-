package com.qhzk.ciep.ui.mine.project;

import com.qhzk.ciep.entity.ProjectManage;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/30.
 */

public interface MineProjectView extends MvpView{

    void onLoadSuccess(List<ProjectManage> projectManages);

    void onLoadNoMore(List<ProjectManage> projectManages);

    void onLoadMore(List<ProjectManage> projectManages);

    void onDeleteSuccess();
}
