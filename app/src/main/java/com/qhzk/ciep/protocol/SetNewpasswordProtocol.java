package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pucheng on 2017/1/11.
 * 设置新密码接口 , POST方式提交
 */

public class SetNewpasswordProtocol extends CiepProtocol {

    private String userEmail;
    private String code;
    private String password;

    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        mParmasMap.put("userEmail", userEmail);
        mParmasMap.put("code", code);
        mParmasMap.put("password", password);
        return mParmasMap;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SetNewpasswordProtocol(Callback mCallback) {
        super(mCallback);
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_IMAGE_URL + "system/pwdrest!changePwd.action";
    }
}
