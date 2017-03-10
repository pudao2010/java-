package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pucheng on 2017/1/5.
 * 找回密码,图形验证码 post方式提交
 */

public class VerifyImgcodeProtocol extends CiepProtocol {

    private String userEmail;
    private String vailcode;
    private String authkey;

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setCode(String code) {
        this.vailcode = code;
    }

    public void setAuthkey(String authkey) {
        this.authkey = authkey;
    }

    public VerifyImgcodeProtocol(Callback mCallback) {
        super(mCallback);
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "system/pwdrest!getVailCode.action";
    }

    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        mParmasMap.put("userEmail", userEmail);
        mParmasMap.put("vailcode", vailcode);
        mParmasMap.put("authkey", authkey);
        return mParmasMap;
    }
}
