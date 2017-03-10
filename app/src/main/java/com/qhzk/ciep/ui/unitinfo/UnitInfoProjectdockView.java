package com.qhzk.ciep.ui.unitinfo;

import com.qhzk.ciep.entity.ProjectDock;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/26.
 */

public interface UnitInfoProjectdockView extends MvpView{

    void onLoadSuccess(List<ProjectDock> projectDocks);
}
