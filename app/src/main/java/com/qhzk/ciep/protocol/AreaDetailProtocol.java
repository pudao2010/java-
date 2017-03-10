package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.AreaDetailBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pucheng on 2017/2/16.
 * 展区详情
 */

public class AreaDetailProtocol extends BaseProtocol<AreaDetailBean> {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "system/section-area/getAreaDetail.action";
    }

    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        mParmasMap.put("area.id", id);
        return mParmasMap;
    }
}
