package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pucheng on 2017/2/8.
 * 我的消息
 */

public class MessageProtocol extends BaseProtocol<com.qhzk.ciep.entity.Message> {

    private int page;
    private int rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "common/message/list.action";
    }

    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        mParmasMap.put("page", page+"");
        mParmasMap.put("rows", rows+"");
        return mParmasMap;
    }
}
