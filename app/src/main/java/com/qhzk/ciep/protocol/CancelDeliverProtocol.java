package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pucheng on 2017/1/16.
 * 个人用户取消对职位投递简历, post方式
 */

public class CancelDeliverProtocol extends CiepProtocol{

    private String id;

    public CancelDeliverProtocol(Callback mCallback) {
        super(mCallback);
    }

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "common/resume-deliver/delete.action";
    }

    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        mParmasMap.put("resumeDeliver.id", id);
        return super.getParmasMap();
    }
}
