package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pucheng on 2017/1/3.
 * 编辑我要参会的个人信息, post方式提交
 */

public class ParticipantProtocol extends CiepProtocol{

    public ParticipantProtocol(Callback mCallback) {
        super(mCallback);
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "partici/participant!add.action";
    }

    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        mParmasMap.put("participant.name", name);                   //姓名
        mParmasMap.put("participant.nationality", nationality);     //国籍
        mParmasMap.put("participant.gender", gender);               //性别
        mParmasMap.put("participant.phoneNum", phoneNum);           // 手机
        mParmasMap.put("participant.email", email);                 // 邮箱
        mParmasMap.put("participant.company", company);             //工作单位
        mParmasMap.put("participant.position", position);           // 职位
        mParmasMap.put("participant.comIndustry", comIndustry);     //行业领域
        mParmasMap.put("participant.comType", comType);             // 单位性质
        mParmasMap.put("participant.comSize", comSize);             //单位规模
        mParmasMap.put("participant.graduated", graduated);         //毕业学校
        mParmasMap.put("participant.educationlevel", educationlevel); //学历学位
        mParmasMap.put("participant.major", major);                 // 所学专业
        mParmasMap.put("participant.purpose", purpose);             //来访目的

        return mParmasMap;
    }

    private String name;
    private String nationality;
    private String gender;
    private String phoneNum;
    private String email;
    private String company;
    private String position;
    private String comIndustry;
    private String comType;
    private String comSize;
    private String graduated;
    private String educationlevel;
    private String major;
    private String purpose;

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setComIndustry(String comIndustry) {
        this.comIndustry = comIndustry;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public void setComSize(String comSize) {
        this.comSize = comSize;
    }

    public void setGraduated(String graduated) {
        this.graduated = graduated;
    }

    public void setEducationlevel(String educationlevel) {
        this.educationlevel = educationlevel;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
