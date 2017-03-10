package com.qhzk.ciep.ui.jobdetail;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.JobDetail;
import com.qhzk.ciep.mvp.BasePresenter;

/**
 * Created by Administrator on 2016/12/23.
 */

public class JobDetailPresenter extends BasePresenter<JobDetailView>{

    /**
     *  根据ID加载职位详情
     */
    public void loadData(String id){
        mApi.getJobDetail(id, new ResultSubscriber<JobDetail>(this) {
            @Override
            public void onSuccess(JobDetail jobDetail) {
                if (jobDetail != null) {
                    getMvpView().onLoadSuccess(jobDetail);
                }
            }
        });
    }

    /**
     *   投递简历
     */
    public void deliver(String positionId){
        mApi.deliver(positionId, new ResultSubscriber<Void>(this) {
            @Override
            public void onSuccess(Void aVoid) {
                getMvpView().onDeliverSuccess();
            }
        });
    }
}
