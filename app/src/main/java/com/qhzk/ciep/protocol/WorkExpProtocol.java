package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.qhzk.ciep.config.ServiceConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/27.
 * 上传个人的工作经历,  post方式提交
 */

public class WorkExpProtocol extends CiepProtocol {

    public WorkExpProtocol(Callback mCallback) {
        super(mCallback);
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "/member/person/resume/work-exp/save.action";
    }
    //    workExperience.id:"*"		        //教育经历ID，有则表示修改，无则表示添加
    //    workExperience.resumeid:"*"       //对应简历基础信息ID 必填
    //    workExperience.startdate;		    //开始时间
    //    workExperience.enddate;			//结束时间
    //    workExperience.company;			//公司
    //    workExperience.position;		    //位置
    //    workExperience.department;		//部门
    //    workExperience.industry			//行业
    //    workExperience.comsize			//公司大小
    //    workExperience.comtype			//公司类型
    //    workExperience.jobtype			//工作类型
    //    workExperience.description;		//描述
    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        if (!TextUtils.isEmpty(id)){
            mParmasMap.put("workExperience.id", id);
        }
        if (!TextUtils.isEmpty(resumeid)){
            mParmasMap.put("workExperience.resumeid", resumeid);
        }
        if (!TextUtils.isEmpty(startdate)){
            mParmasMap.put("workExperience.startdate", startdate);
        }
        if (!TextUtils.isEmpty(enddate)){
            mParmasMap.put("workExperience.enddate", enddate);
        }
        if (!TextUtils.isEmpty(company)){
            mParmasMap.put("workExperience.company", company);
        }
        if (!TextUtils.isEmpty(position)){
            mParmasMap.put("workExperience.position", position);
        }
        if (!TextUtils.isEmpty(department)){
            mParmasMap.put("workExperience.department", department);
        }
        if (!TextUtils.isEmpty(industry)){
            mParmasMap.put("workExperience.industry", industry);
        }
        if (!TextUtils.isEmpty(comsize)){
            mParmasMap.put("workExperience.comsize", comsize);
        }
        if (!TextUtils.isEmpty(comtype)){
            mParmasMap.put("workExperience.comtype", comtype);
        }
        if (!TextUtils.isEmpty(jobtype)){
            mParmasMap.put("workExperience.jobtype", jobtype);
        }
        if (!TextUtils.isEmpty(description)){
            mParmasMap.put("workExperience.description", description);
        }
        return mParmasMap;
    }

  private  String id;
  private  String resumeid;
  private  String startdate;
  private  String enddate;
  private  String company;
  private  String position;
  private  String department;
  private  String industry;
  private  String comsize;
  private  String comtype;
  private  String jobtype;
  private  String description;

    public void setId(String id) {
        this.id = id;
    }

    public void setResumeid(String resumeid) {
        this.resumeid = resumeid;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setComsize(String comsize) {
        this.comsize = comsize;
    }

    public void setComtype(String comtype) {
        this.comtype = comtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
