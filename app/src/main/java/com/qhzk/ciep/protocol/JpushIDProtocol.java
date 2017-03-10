package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pucheng on 2017/1/12.
 * POST方式提交 ,极光推送注册的ID
 */

public class JpushIDProtocol extends CiepProtocol {

    private String registrationId;

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public JpushIDProtocol(Callback mCallback) {
        super(mCallback);
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "login/updateRegistrationId.action";
    }

    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        if (registrationId != null) {
            mParmasMap.put("registrationId", registrationId);
        }
        return mParmasMap;
    }
}
