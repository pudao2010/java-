package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.PlateEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/29.
 */

public class PlateDetailProtocol extends BaseProtocol<PlateEntity>{
    private int id;

    public PlateDetailProtocol(int id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "system/section/getSectionDetail.action";
    }

    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        mParmasMap.put("section.id",id+"");
        return mParmasMap;
    }
}
