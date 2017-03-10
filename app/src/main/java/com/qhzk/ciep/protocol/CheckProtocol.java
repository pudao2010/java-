package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pucheng on 2017/1/22.
 * 校验当前登录用户是否为个人用户, POST方式
 */

public class CheckProtocol extends CiepProtocol{

    private String userCode;

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public CheckProtocol(Callback mCallback) {
        super(mCallback);
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "login/checkPersonOrNot.action";
    }

    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        mParmasMap.put("userCode", userCode);
        return mParmasMap;
    }
}
