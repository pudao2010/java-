package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.SearchNewEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/30.
 * 首页搜索新闻
 */

public class SearchNewProtocol extends BaseProtocol<SearchNewEntity> {

    private String keyword;

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "search/list.action";
    }

    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        mParmasMap.put("keyword", keyword);
        return mParmasMap;
    }
}
