package com.qhzk.ciep.ui.mine.resume.edu_exp.reset;

import com.qhzk.ciep.entity.Resume;
import com.qhzk.ciep.entity.ResumeEntity;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by pucheng on 2017/1/6.
 */

public interface ResetEduExpView extends MvpView{

    void onCommitSuccess();

    void onLoadSuccess(ResumeEntity resumeEntity);

    void onLoadResume(Resume resume);
}
