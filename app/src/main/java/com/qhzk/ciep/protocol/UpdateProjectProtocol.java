package com.qhzk.ciep.protocol;

import android.support.annotation.NonNull;

import com.qhzk.ciep.config.ServiceConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/30.
 * post方式提交  个人发布项目进行修改
 */

public class UpdateProjectProtocol extends CiepProtocol {
    public UpdateProjectProtocol(Callback mCallback) {
        super(mCallback);
    }

    @NonNull
    @Override
    public String getUrl() {
        return ServiceConfig.BASE_URL + "common/project/save.action";
    }
//    project.id;					//项目id     修改项目必填
//    project.name;					//项目名称
//    project.type;					//项目类型
//    project.sector;				//行业领域
//    project.contacts;				//联系人
//    project.contactstitle;		//联系人职位
//    project.mobile;				//联系人手机
//    project.phone;				//座机
//    project.email;				//邮箱
//    project.fax;					//传真
//    project.introduction;			//项目介绍
//    project.orgintroduction;		//单位介绍
    @Override
    protected Map<String, String> getParmasMap() {
        mParmasMap = new HashMap<>();
        if (id != null) {
            mParmasMap.put("project.id", id);
        }
        if (name != null) {
            mParmasMap.put("project.name", name);
        }
        if (type != null) {
            mParmasMap.put("project.type", type);
        }
        if (sector != null) {
            mParmasMap.put("project.sector", sector);
        }
        if (contacts != null) {
            mParmasMap.put("project.contacts", contacts);
        }
        if (contactstitle != null) {
            mParmasMap.put("project.contactstitle", contactstitle);
        }
        if (mobile != null) {
            mParmasMap.put("project.mobile", mobile);
        }
        if (phone != null) {
            mParmasMap.put("project.phone", phone);
        }
        if (email != null) {
            mParmasMap.put("project.email", email);
        }
        if (fax != null) {
            mParmasMap.put("project.fax", fax);
        }
        if (introduction != null) {
            mParmasMap.put("project.introduction", introduction);
        }
        if (orgintroduction != null) {
            mParmasMap.put("project.orgintroduction", orgintroduction);
        }
        return mParmasMap;
    }
   private String id;
   private String name;
   private String type;
   private String sector;
   private String contacts;
   private String contactstitle;
   private String mobile;
   private String phone;
   private String email;
   private String fax;
   private String introduction;
   private String orgintroduction;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public void setContactstitle(String contactstitle) {
        this.contactstitle = contactstitle;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setOrgintroduction(String orgintroduction) {
        this.orgintroduction = orgintroduction;
    }
}
