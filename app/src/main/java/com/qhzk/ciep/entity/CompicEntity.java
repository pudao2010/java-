package com.qhzk.ciep.entity;

/**
 * Created by Thisdk on 2016/9/18.
 */

public class CompicEntity {

    private String id;
    private String name;
    private String logopath;
    private String weburl;
    private String isshow;
    private String showpos;
    private String createuser;
    private String createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogopath() {
        return logopath;
    }

    public void setLogopath(String logopath) {
        this.logopath = logopath;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public String getIsshow() {
        return isshow;
    }

    public void setIsshow(String isshow) {
        this.isshow = isshow;
    }

    public String getShowpos() {
        return showpos;
    }

    public void setShowpos(String showpos) {
        this.showpos = showpos;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "CompicEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", logopath='" + logopath + '\'' +
                ", weburl='" + weburl + '\'' +
                ", isshow='" + isshow + '\'' +
                ", showpos='" + showpos + '\'' +
                ", createuser='" + createuser + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }

}
