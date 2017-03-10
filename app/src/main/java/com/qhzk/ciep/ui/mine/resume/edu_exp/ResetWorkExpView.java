package com.qhzk.ciep.ui.mine.resume.edu_exp;

import com.qhzk.ciep.entity.Resume;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */

public interface ResetWorkExpView extends MvpView{

    void onLoadSuccess(List<Resume.ResumeBean.WorkExperienceListBean> workExperienceList);

    void onLoadFailed(Exception e);

    void onCommitSuccess();

    void onDeleteSuccess();
}
