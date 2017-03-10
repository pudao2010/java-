package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;
import com.qhzk.ciep.entity.Resume;

import java.util.Map;

/**
 * Created by Administrator on 2016/12/27.
 * 蒲导
 */

public class ResumeProtocol extends BaseProtocol<Resume> {
    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "member/person/resume/myResume.action";
    }


    @Override
    protected Map<String, String> getParmasMap() {
        return super.getParmasMap();
    }

    /**
     * 添加请求头, 从cookie中获取
     */
//    protected Map<String, String> getHeadersMap() {
//        HashMap<String, String> headersMap = new HashMap<>();
//        CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(CiepApplication.getApplication()));
//        CookieStore cookieStore = cookieJar.getCookieStore();
//        String tempCookies = "";
//        if (cookieStore != null) {
//            for (Cookie c : cookieStore.getCookies()){
//                tempCookies += (c.name() + "=" +c.value())+";";
//            }
//        }
//        headersMap.put("Cookie", tempCookies);
//        return headersMap;
//    }
}
