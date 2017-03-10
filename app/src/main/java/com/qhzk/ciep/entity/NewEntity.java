package com.qhzk.ciep.entity;

/**
 * Created by Thisdk on 2016/9/18.
 */

public class NewEntity {

    private String id;
    private String title;
    private String typecode;
    private String pcimg;
    private String phoneimg;
    private String introduction;
    private String url;
    private String authorid;
    private String author;
    private String comefrom;
    private String orderx;
    private String createtime;
    private String createname;
    private String viewtimes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getPcimg() {
        return pcimg;
    }

    public void setPcimg(String pcimg) {
        this.pcimg = pcimg;
    }

    public String getPhoneimg() {
        return phoneimg;
    }

    public void setPhoneimg(String phoneimg) {
        this.phoneimg = phoneimg;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthorid() {
        return authorid;
    }

    public void setAuthorid(String authorid) {
        this.authorid = authorid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComefrom() {
        return comefrom;
    }

    public void setComefrom(String comefrom) {
        this.comefrom = comefrom;
    }

    public String getOrderx() {
        return orderx;
    }

    public void setOrderx(String orderx) {
        this.orderx = orderx;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname;
    }

    public String getViewtimes() {
        return viewtimes;
    }

    public void setViewtimes(String viewtimes) {
        this.viewtimes = viewtimes;
    }

    @Override
    public String toString() {
        return "NewEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", typecode='" + typecode + '\'' +
                ", pcimg='" + pcimg + '\'' +
                ", phoneimg='" + phoneimg + '\'' +
                ", introduction='" + introduction + '\'' +
                ", url='" + url + '\'' +
                ", authorid='" + authorid + '\'' +
                ", author='" + author + '\'' +
                ", comefrom='" + comefrom + '\'' +
                ", orderx='" + orderx + '\'' +
                ", createtime='" + createtime + '\'' +
                ", createname='" + createname + '\'' +
                ", viewtimes='" + viewtimes + '\'' +
                '}';
    }
}
