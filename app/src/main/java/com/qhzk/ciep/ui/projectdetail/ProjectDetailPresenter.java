package com.qhzk.ciep.ui.projectdetail;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.ProjectDetail;
import com.qhzk.ciep.mvp.BasePresenter;

/**
 * Created by Administrator on 2016/12/21.
 */

public class ProjectDetailPresenter extends BasePresenter<ProjectDetailView> {

    public void loadData(String projectId){
        mApi.getProjectDetail(projectId, new ResultSubscriber<ProjectDetail>(this) {
            @Override
            public void onSuccess(ProjectDetail projectDetail) {
                getMvpView().onLoadSuccess(projectDetail);
            }
        });
    }
}
