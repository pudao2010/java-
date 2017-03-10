package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.CiepVideo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pucheng on 2017/1/12.
 *
 */

public class CiepVideoProtocol extends BaseProtocol<CiepVideo> {

    private int page = 1;

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "video/vod/vod!vodlist.action";
    }

    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        mParmasMap.put("page", page+"");
        mParmasMap.put("rows", "20");
        return mParmasMap;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
