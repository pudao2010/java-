package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pucheng on 2017/1/12.
 * 意见反馈, POST方式提交
 */

public class FeedbackProtocol extends CiepProtocol {

    private String userId;
    private String usercode;
    private String content;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public FeedbackProtocol(Callback mCallback) {
        super(mCallback);
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "system/feedback!saveOrUpdate.action";
    }

    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        if (userId != null) {
            mParmasMap.put("feedback.userId", userId);
        }
        if (usercode != null) {
            mParmasMap.put("feedback.usercode", usercode);
        }
        if (content != null) {
            mParmasMap.put("feedback.content", content);
        }
        return mParmasMap;
    }
}
