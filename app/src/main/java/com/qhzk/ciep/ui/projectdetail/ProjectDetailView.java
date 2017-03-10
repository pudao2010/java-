package com.qhzk.ciep.ui.projectdetail;

import com.qhzk.ciep.entity.ProjectDetail;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/21.
 */

public interface ProjectDetailView extends MvpView{

    void onLoadSuccess(ProjectDetail projectDetail);
}
