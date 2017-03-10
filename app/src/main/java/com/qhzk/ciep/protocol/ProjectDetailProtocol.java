package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.TempEn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/21.
 * 项目详情
 */

public class ProjectDetailProtocol extends BaseProtocol<TempEn> {

    private String mId;

    public ProjectDetailProtocol(String id) {
        this.mId = id;
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "project/detail.action";
    }

    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        mParmasMap.put("project.id", mId);
        return mParmasMap;
    }
}
