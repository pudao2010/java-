package com.qhzk.ciep.ui.qrcode;

import com.google.gson.internal.LinkedTreeMap;
import com.qhzk.ciep.mvp.MvpView;

/**
 * Created by Thisdk on 2016/9/8.
 */

public interface QRcodeView extends MvpView {

    void onQRcodeInfo(LinkedTreeMap map);

}
