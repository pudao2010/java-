package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/28.
 * 查询 职位是否已经投递
 */

public class CheckDeliverProtocol extends CiepProtocol {

    private String positionId;

    public CheckDeliverProtocol(Callback mCallback) {
        super(mCallback);
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "common/resume-deliver/isDelivered.action";
    }

    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        if (positionId != null) {
            mParmasMap.put("resumeDeliver.positionId", positionId);
        }
        return mParmasMap;
    }
}
