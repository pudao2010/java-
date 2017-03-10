package com.qhzk.ciep.ui.mine.project;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.ProjectManage;
import com.qhzk.ciep.mvp.BasePresenter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/30.
 */

public class MineProjectPresenter extends BasePresenter<MineProjectView> {
    private int page = 1;
    public void loadData(int page, int rows){
        mApi.getProjectList(page, rows, new ResultSubscriber<List<ProjectManage>>(this) {
            @Override
            public void onSuccess(List<ProjectManage> projectManages) {
                getMvpView().onLoadSuccess(projectManages);
            }
        });
    }

    public void loadMore(){
        mApi.getProjectList(++page, 20, new ResultSubscriber<List<ProjectManage>>(this) {
            @Override
            public void onSuccess(List<ProjectManage> projectManages) {
                if (projectManages.size() < 20){
                    getMvpView().onLoadNoMore(projectManages);
                }else{
                    getMvpView().onLoadMore(projectManages);
                }
            }
        });
    }

    public void deleteProject(String id) {
        mApi.deleteProject(id, new ResultSubscriber<Void>(this) {
            @Override
            public void onSuccess(Void aVoid) {
                getMvpView().onDeleteSuccess();
            }
        });
    }
}
