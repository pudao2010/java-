package com.qhzk.ciep.ui.mine.resume.reset_data;

import com.qhzk.ciep.entity.Resume;
import com.qhzk.ciep.entity.ResumeEntity;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Administrator on 2016/12/27.
 */

public interface MineResetDataView extends MvpView{

    void onLoadSuccess(ResumeEntity resumeEntity);

    void onCommitResumeInfoSuccess();

    void onLoadResume(Resume resume);
}
