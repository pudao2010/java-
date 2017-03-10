package com.qhzk.ciep.ui.mine.setting.feedback;

import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by pucheng on 2017/1/12.
 *
 */

public interface FeedbackView extends MvpView{

    void onError(Exception e);

    void onCommitSuccess();

    void onCommitFailed();
}
