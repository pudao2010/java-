package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.qhzk.ciep.config.ServiceConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/27.
 * 上传简历的基本信息,通过GET方式提交
 */

public class ResumeInfoProtocol extends CiepProtocol {
    public ResumeInfoProtocol(Callback mCallback) {
        super(mCallback);
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "member/person/resume/update.action";
    }

    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        mParmasMap.put("updateType", "0"); // 0表示基本信息
        // 简历id(更新简历时需要传的参数, id可以从简历详情接口中获得)
        // 如果是添加新的简历,则不需要传id
        if (!TextUtils.isEmpty(id)){
            mParmasMap.put("resumeInfo.id", id);
        }
        if (!TextUtils.isEmpty(userid)){   // 简历对应用户id
            mParmasMap.put("userid", userid);
        }
        if (!TextUtils.isEmpty(name)){
            mParmasMap.put("resumeInfo.name", name); //姓名 :
        }
        if (!TextUtils.isEmpty(gender)){
            mParmasMap.put("resumeInfo.gender", gender); // 性别: 男 / 女
        }
        if (!TextUtils.isEmpty(birthday)){
            mParmasMap.put("resumeInfo.birthday", birthday); //生日: 2016-11-01
        }
        if (!TextUtils.isEmpty(mobile)){
            mParmasMap.put("resumeInfo.mobile", mobile); // 手机
        }
        if (!TextUtils.isEmpty(email)){
            mParmasMap.put("resumeInfo.email", email); // 邮箱
        }
        if (!TextUtils.isEmpty(yearsofwork)){
            mParmasMap.put("resumeInfo.yearsofwork", yearsofwork); //工作年限
        }
        if (!TextUtils.isEmpty(residency)){
            mParmasMap.put("resumeInfo.residency", residency); // 居住地 格式:
        }
        if (!TextUtils.isEmpty(salary)){
            mParmasMap.put("resumeInfo.salary", salary); // 薪水: 20000元
        }
        if (!TextUtils.isEmpty(height)){
            mParmasMap.put("resumeInfo.height", height); // 身高: 180
        }
        if (!TextUtils.isEmpty(maritalstatus)){
            mParmasMap.put("resumeInfo.maritalstatus", maritalstatus);// 婚姻状态: 未婚 / 已婚
        }
        if (!TextUtils.isEmpty(qq)){
            mParmasMap.put("resumeInfo.qq", qq); // QQ
        }
        if (!TextUtils.isEmpty(wechat)){
            mParmasMap.put("resumeInfo.wechat", wechat); // 微信
        }
        return mParmasMap;
    }

//    "id": "1",										//id
//    "userid": "4028902b55ac1fef0155ac6cec7e0004",		//简历对应用户ID
//    "name": "姓名",									//姓名
//    "gender": 1,										//性别：女/男
//    "birthday": "2016-11-01",							//生日
//    "mobile": "手机",									//手机
//    "email": "email",									//email
//    "yearsofwork":	1								//工作年限
//    "residency": "居住地",								//居住地
//    "salary": 1,										//目前薪资
//    "height": 1,										//身高。单位cm
//    "maritalstatus": "婚姻状态",						//婚姻状态
//    "qq": "QQ",										//QQ
//    "wechat": "微信",                                 //微信

       private  String   id;
       private  String   userid;
       private  String   name;
       private  String   gender;
       private  String   birthday;
       private  String   mobile;
       private  String   email;
       private  String   yearsofwork;
       private  String   residency;
       private  String   salary;
       private  String   height;
       private  String   maritalstatus;
       private  String   qq;
       private  String   wechat;

    public void setId(String id) {
        this.id = id;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setYearsofwork(String yearsofwork) {
        this.yearsofwork = yearsofwork;
    }

    public void setResidency(String residency) {
        this.residency = residency;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
}
