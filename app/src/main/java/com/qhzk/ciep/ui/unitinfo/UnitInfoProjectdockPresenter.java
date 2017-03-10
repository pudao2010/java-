package com.qhzk.ciep.ui.unitinfo;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.ProjectDock;
import com.qhzk.ciep.mvp.BasePresenter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/26.
 */

public class UnitInfoProjectdockPresenter extends BasePresenter<UnitInfoProjectdockView> {

    public void loadData(String userId){
        mApi.getProjectDocks(userId, new ResultSubscriber<List<ProjectDock>>(this) {
            @Override
            public void onSuccess(List<ProjectDock> projectDocks) {
                getMvpView().onLoadSuccess(projectDocks);
            }
        });
    }
}
