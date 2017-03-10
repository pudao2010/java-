package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pucheng on 2017/1/11.
 * 用来验证发送给邮箱的验证码, POST方式提交
 */

public class EmailCodeProtocol extends CiepProtocol{

    private String userEmail;
    private String code;

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public EmailCodeProtocol(Callback mCallback) {
        super(mCallback);
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "system/pwdrest!vaildation.action";
    }

    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        mParmasMap.put("userEmail", userEmail);
        mParmasMap.put("code", code);
        return mParmasMap;
    }
}
