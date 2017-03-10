package com.qhzk.ciep.ui.mine.resume.edu_exp.reset;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.Resume;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.protocol.BaseProtocol;
import com.qhzk.ciep.protocol.ResumeProtocol;

import java.util.Map;

import okhttp3.Call;

/**
 * Created by pucheng on 2017/1/6.
 */

public class ResetEduExpPresenter extends BasePresenter<ResetEduExpView> {

    public void commitEduExp(Map<String, String> params){
        mApi.commitEduExp(params, new ResultSubscriber<Void>(this) {
            @Override
            public void onSuccess(Void aVoid) {
                getMvpView().onCommitSuccess();
            }
        });
    }

    public void getMyResumeId() {
        ResumeProtocol protocol = new ResumeProtocol();
        protocol.loadDataByGet(new BaseProtocol.Callback<Resume>() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(Resume resume, int id) {
                if (resume != null) {
                    getMvpView().onLoadResume(resume);
                }
            }
        });
    }
}
