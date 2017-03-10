package com.qhzk.ciep.ui.mine.setting.feedback;

import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.protocol.CiepProtocol;
import com.qhzk.ciep.protocol.FeedbackProtocol;

import okhttp3.Call;

/**
 * Created by pucheng on 2017/1/12.
 *
 */

public class FeedbackPresenter extends BasePresenter<FeedbackView> {

    public void commitFeedback(String userId, String usercode, String content){
        FeedbackProtocol protocol = new FeedbackProtocol(new CiepProtocol.Callback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                getMvpView().onError(e);
            }

            @Override
            public void onSuccess() {
                getMvpView().onCommitSuccess();
            }

            @Override
            public void onFailed() {
                getMvpView().onCommitFailed();
            }
        });
        protocol.setUserId(userId);
        protocol.setUsercode(usercode);
        protocol.setContent(content);
        protocol.uploadDataByPost();
    }
}
