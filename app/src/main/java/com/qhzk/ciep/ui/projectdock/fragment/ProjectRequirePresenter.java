package com.qhzk.ciep.ui.projectdock.fragment;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.ProjectRequireEntity;
import com.qhzk.ciep.mvp.BasePresenter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */

public class ProjectRequirePresenter extends BasePresenter<ProjectRequireView> {

    public int page = 1;

    public void loadData(String searchType){
        getMvpView().showProgress();
        mApi.getProjectRequire(searchType,1, 20, new ResultSubscriber<List<ProjectRequireEntity>>(this) {
            @Override
            public void onSuccess(List<ProjectRequireEntity> list) {
                getMvpView().hideProgress();
                if (list != null) {
                    getMvpView().onLoadSuccess(list);
                }
            }
        });
    }

    public void loadMore(String searchType){
        mApi.getProjectRequire(searchType, ++page, 20, new ResultSubscriber<List<ProjectRequireEntity>>(this) {
            @Override
            public void onSuccess(List<ProjectRequireEntity> list) {
                if (list != null) {
                    getMvpView().onLoadMore(list);
                }
            }
        });
    }

    public void filter(String projectName, String projectType, String sector, String releaseType, String searchType) {
        getMvpView().showProgress();
        mApi.getSearchProject(projectName, projectType, sector, releaseType, searchType, new ResultSubscriber<List<ProjectRequireEntity>>(this) {
            @Override
            public void onSuccess(List<ProjectRequireEntity> list) {
                getMvpView().hideProgress();
                if (list.size() > 1){
                    getMvpView().onFilterSuccess(list);
                }else{
                    getMvpView().onFilterFailed(list);
                }
            }
        });
    }
}
