package com.qhzk.ciep.ui.jobdetail;

import com.qhzk.ciep.entity.JobDetail;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/23.
 */

public interface JobDetailView extends MvpView{
    void onLoadSuccess(JobDetail jobDetail);

    void onDeliverSuccess();
}
