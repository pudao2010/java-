package com.qhzk.ciep.ui.mine.resume.edu_exp.reset;

import com.qhzk.ciep.entity.Resume;
import com.qhzk.ciep.mvp.MvpView;

import java.util.List;

/**
 * Created by pucheng on 2017/1/12.
 *
 */

public interface EduExpView extends MvpView{

    void onLoadEduSuccess(List<Resume.ResumeBean.EducationListBean> educationList);

    void onLoadFailed(Exception e);

    void onDeleteSuccess();
}
