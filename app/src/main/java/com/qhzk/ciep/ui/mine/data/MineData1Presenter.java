package com.qhzk.ciep.ui.mine.data;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.mvp.BasePresenter;

import java.util.Map;

/**
 * Created by pucheng on 2017/1/7.
 */

public class MineData1Presenter extends BasePresenter<MineData1View> {

    public void commitMineData(Map<String, String> params){
        mApi.commitMineData(params, new ResultSubscriber<Void>(this) {
            @Override
            public void onSuccess(Void aVoid) {
                getMvpView().onCommitSuccess();
            }
        });
    }
}
