package com.qhzk.ciep.ui.mine.resume.edu_exp;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.Resume;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.protocol.BaseProtocol;
import com.qhzk.ciep.protocol.ResumeProtocol;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/28.
 */

public class ResetWorkExpPresenter extends BasePresenter<ResetWorkExpView> {

    public void loadData(){

        ResumeProtocol protocol = new ResumeProtocol();
        protocol.loadDataByGet(new BaseProtocol.Callback<Resume>() {
            @Override
            public void onError(Call call, Exception e, int id) {
                getMvpView().onLoadFailed(e);
            }

            @Override
            public void onResponse(Resume resume, int id) {
                if (resume != null && resume.getResume() != null && resume.getResume().getWorkExperienceList() != null) {
                    getMvpView().onLoadSuccess(resume.getResume().getWorkExperienceList());
                }
            }
        });
    }

    /**
     *  根据id删除对应的工作经历, 工作经历对应 deleteType = 2
     */
    public void deleteWorkExp(String id) {
        mApi.deleteResume(2, id, new ResultSubscriber<Void>(this) {
            @Override
            public void onSuccess(Void aVoid) {
                getMvpView().onDeleteSuccess();
            }
        });
    }
}
