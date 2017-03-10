package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.UnitInfoTalent;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pucheng on 2017/1/19.
 * 单位信息里面的人才对接, POST方式
 */

public class UnitInfoTalentProtocol extends BaseProtocol<UnitInfoTalent> {

    private int page;
    private String entId;

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "position/position!entPositions.action";
    }

    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        mParmasMap.put("page", page+"");
        mParmasMap.put("rows", "20");
        mParmasMap.put("entId", entId);
        return mParmasMap;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setEntId(String entId) {
        this.entId = entId;
    }
}
