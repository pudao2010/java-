package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.MeetingEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/22.
 * 我要参会下拉菜单
 */

public class MeetingProtocol extends BaseProtocol<List<MeetingEntity>>{

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "system/section/getAllSectionList.action";
    }

    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        mParmasMap.put("type","meeting");
        return mParmasMap;
    }
}
