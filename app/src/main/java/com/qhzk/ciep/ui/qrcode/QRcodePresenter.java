package com.qhzk.ciep.ui.qrcode;

import com.google.gson.internal.LinkedTreeMap;
import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.mvp.BasePresenter;

/**
 * Created by Thisdk on 2016/9/8.
 */

public class QRcodePresenter extends BasePresenter<QRcodeView> {

    public void getQRcodeInfo(String action, String body) {
        mApi.getQRcodeInfo(action, body, new ResultSubscriber<LinkedTreeMap>(this) {
            @Override
            public void onSuccess(LinkedTreeMap map) {
                getMvpView().onQRcodeInfo(map);
            }
        });
    }

}
