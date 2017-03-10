package com.qhzk.ciep.ui.mine.resume.edu_exp.reset;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.Resume;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.protocol.BaseProtocol;
import com.qhzk.ciep.protocol.ResumeProtocol;

import okhttp3.Call;

/**
 * Created by pucheng on 2017/1/12.
 *
 */

public class EduExpPresenter extends BasePresenter<EduExpView> {

    public void loadResume(){
        ResumeProtocol protocol = new ResumeProtocol();
        protocol.loadDataByGet(new BaseProtocol.Callback<Resume>() {
            @Override
            public void onError(Call call, Exception e, int id) {
                getMvpView().onLoadFailed(e);
            }

            @Override
            public void onResponse(Resume resume, int id) {
                if (resume != null && resume.getResume() != null && resume.getResume().getEducationList() != null) {
                    getMvpView().onLoadEduSuccess(resume.getResume().getEducationList());
                }
            }
        });
    }

    /**
     *  根据id删除对应的教育经历 教育经历对应的deleteType = 1;
     */
    public void deleteEduExp(String id) {
        mApi.deleteResume(1, id, new ResultSubscriber<Void>(this) {
            @Override
            public void onSuccess(Void aVoid) {
                getMvpView().onDeleteSuccess();
            }
        });
    }
}
