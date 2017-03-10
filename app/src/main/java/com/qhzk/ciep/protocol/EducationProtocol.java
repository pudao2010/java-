package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.qhzk.ciep.config.ServiceConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/27.
 * 上传个人的教育经历, post方式提交
 */

public class EducationProtocol extends CiepProtocol {

    public EducationProtocol(Callback mCallback) {
        super(mCallback);
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "member/person/resume/education/save.action";
    }
    //    education.id:"*"		    //教育经历ID，有则表示修改，无则表示添加
    //    education.resumeid:"*"    //对应简历基础信息ID 必填
    //    education.startdate;		//开始时间 2016/01
    //    education.enddate;	    //结束时间 2016/01
    //    education.school;			//院校
    //    education.degree;			//学历学位
    //    education.major;			//专业
    //    education.description;    //描述
    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        if (!TextUtils.isEmpty(id)){
            mParmasMap.put("education.id", id);
        }
        mParmasMap.put("education.resumeid", resumeid);
        if (!TextUtils.isEmpty(startdate)){
            mParmasMap.put("education.startdate", startdate);
        }
        if (!TextUtils.isEmpty(enddate)){
            mParmasMap.put("education.enddate", enddate);
        }
        if (!TextUtils.isEmpty(school)){
            mParmasMap.put("education.school", school);
        }
        if (!TextUtils.isEmpty(degree)){
            mParmasMap.put("education.degree", degree);
        }
        if (!TextUtils.isEmpty(major)){
            mParmasMap.put("education.major", major);
        }
        if (!TextUtils.isEmpty(description)){
            mParmasMap.put("education.description", description);
        }
        return mParmasMap;
    }

    private String id;
    private String resumeid;
    private String startdate;
    private String enddate;
    private String school;
    private String degree;
    private String major;
    private String description;

    public void setId(String id) {
        this.id = id;
    }

    public void setResumeid(String resumeid) {
        this.resumeid = resumeid;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
