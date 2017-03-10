package com.qhzk.ciep.ui.mine.resume.reset_data;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.Resume;
import com.qhzk.ciep.entity.ResumeEntity;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.protocol.BaseProtocol;
import com.qhzk.ciep.protocol.ResumeProtocol;

import java.util.Map;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/27.
 *
 */

public class MineResetDataPresenter extends BasePresenter<MineResetDataView> {

    // 为了拿到简历的id
    public void getMyResume(){

        mApi.getMyResume(new ResultSubscriber<ResumeEntity>(this) {
            @Override
            public void onSuccess(ResumeEntity resumeEntity) {
                //  为什么resumeEntity为空 ?
                System.out.println(resumeEntity);
                getMvpView().onLoadSuccess(resumeEntity);
            }

            @Override
            protected void onError(String error) {
                super.onError(error);
                System.out.println(error);
            }
        });
    }


    public void commitResumeInfo(Map<String, String> options){
        mApi.commitResumeInfo(options, new ResultSubscriber<Void>(this) {
            @Override
            public void onSuccess(Void aVoid) {
                getMvpView().onCommitResumeInfoSuccess();
            }
        });
    }

    public void getResumeId() {
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
