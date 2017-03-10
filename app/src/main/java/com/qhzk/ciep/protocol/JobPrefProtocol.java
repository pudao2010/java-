package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.qhzk.ciep.config.ServiceConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/27.
 * 上传个人的求职意向, post方式提交
 */

public class JobPrefProtocol extends CiepProtocol {

    public JobPrefProtocol(Callback mCallback) {
        super(mCallback);
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "member/person/resume/job-pre/save.action";
    }
//    jobPreferences.resumeid:"*"  	//对应简历基础信息ID 必填
//    jobPreferences.position;		//职位
//    jobPreferences.location;		//地点
//    jobPreferences.jobtype; 		//工作类型
//    jobPreferences.targetsalary;	//期望薪资
//    jobPreferences.dutytime;		//到岗时间
//    jobPreferences.selfdesc;		//自我描述
//    jobPreferences.industry;		//行业
    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        if (!TextUtils.isEmpty(resumeid)){
            mParmasMap.put("jobPreferences.resumeid", resumeid);
        }
        if (!TextUtils.isEmpty(position)){
            mParmasMap.put("jobPreferences.position", position);
        }
        if (!TextUtils.isEmpty(location)){
            mParmasMap.put("jobPreferences.location", location);
        }
        if (!TextUtils.isEmpty(jobtype)){
            mParmasMap.put("jobPreferences.jobtype", jobtype);
        }
        if (!TextUtils.isEmpty(targetsalary)){
            mParmasMap.put("jobPreferences.targetsalary", targetsalary);
        }
        if (!TextUtils.isEmpty(dutytime)){
            mParmasMap.put("jobPreferences.dutytime", dutytime);
        }
        if (!TextUtils.isEmpty(selfdesc)){
            mParmasMap.put("jobPreferences.selfdesc", selfdesc);
        }
        if (!TextUtils.isEmpty(industry)){
            mParmasMap.put("jobPreferences.industry", industry);
        }
        return mParmasMap;
    }
    private String resumeid;
    private String position;
    private String location;
    private String jobtype;
    private String targetsalary;
    private String dutytime;
    private String selfdesc;
    private String industry;

    public void setResumeid(String resumeid) {
        this.resumeid = resumeid;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public void setTargetsalary(String targetsalary) {
        this.targetsalary = targetsalary;
    }

    public void setDutytime(String dutytime) {
        this.dutytime = dutytime;
    }

    public void setSelfdesc(String selfdesc) {
        this.selfdesc = selfdesc;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
}
