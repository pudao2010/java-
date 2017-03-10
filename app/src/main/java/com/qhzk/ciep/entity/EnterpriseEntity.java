package com.qhzk.ciep.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Thisdk on 2016/9/8.
 */

public class EnterpriseEntity implements Parcelable {

    private boolean bdelete;
    private String id;
    private String name;
    private String ename;
    private String contrct;
    private String mobile;
    private String telephone;
    private String faxnum;
    private String industry;
    private String enttype;
    private String entsize;
    private String regionProv;
    private String regionCity;
    private String regionDistrict;
    private int exYears;
    private String entDesc;
    private String createDate;
    private String logoImg;
    private String pdfUrl;
    private String profile;
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public boolean isBdelete() {
        return bdelete;
    }

    public void setBdelete(boolean bdelete) {
        this.bdelete = bdelete;
    }

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

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getContrct() {
        return contrct;
    }

    public void setContrct(String contrct) {
        this.contrct = contrct;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFaxnum() {
        return faxnum;
    }

    public void setFaxnum(String faxnum) {
        this.faxnum = faxnum;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getEnttype() {
        return enttype;
    }

    public void setEnttype(String enttype) {
        this.enttype = enttype;
    }

    public String getEntsize() {
        return entsize;
    }

    public void setEntsize(String entsize) {
        this.entsize = entsize;
    }

    public String getRegionProv() {
        return regionProv;
    }

    public void setRegionProv(String regionProv) {
        this.regionProv = regionProv;
    }

    public String getRegionCity() {
        return regionCity;
    }

    public void setRegionCity(String regionCity) {
        this.regionCity = regionCity;
    }

    public String getRegionDistrict() {
        return regionDistrict;
    }

    public void setRegionDistrict(String regionDistrict) {
        this.regionDistrict = regionDistrict;
    }

    public int getExYears() {
        return exYears;
    }

    public void setExYears(int exYears) {
        this.exYears = exYears;
    }

    public String getEntDesc() {
        return entDesc;
    }

    public void setEntDesc(String entDesc) {
        this.entDesc = entDesc;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLogoImg() {
        return logoImg;
    }

    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.bdelete ? (byte) 1 : (byte) 0);
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.ename);
        dest.writeString(this.contrct);
        dest.writeString(this.mobile);
        dest.writeString(this.telephone);
        dest.writeString(this.faxnum);
        dest.writeString(this.industry);
        dest.writeString(this.enttype);
        dest.writeString(this.entsize);
        dest.writeString(this.regionProv);
        dest.writeString(this.regionCity);
        dest.writeString(this.regionDistrict);
        dest.writeInt(this.exYears);
        dest.writeString(this.entDesc);
        dest.writeString(this.createDate);
        dest.writeString(this.logoImg);
        dest.writeString(this.pdfUrl);
        dest.writeString(this.profile);
        dest.writeString(this.time);
    }

    public EnterpriseEntity() {
    }

    protected EnterpriseEntity(Parcel in) {
        this.bdelete = in.readByte() != 0;
        this.id = in.readString();
        this.name = in.readString();
        this.ename = in.readString();
        this.contrct = in.readString();
        this.mobile = in.readString();
        this.telephone = in.readString();
        this.faxnum = in.readString();
        this.industry = in.readString();
        this.enttype = in.readString();
        this.entsize = in.readString();
        this.regionProv = in.readString();
        this.regionCity = in.readString();
        this.regionDistrict = in.readString();
        this.exYears = in.readInt();
        this.entDesc = in.readString();
        this.createDate = in.readString();
        this.logoImg = in.readString();
        this.pdfUrl = in.readString();
        this.profile = in.readString();
        this.time = in.readString();
    }

    public static final Parcelable.Creator<EnterpriseEntity> CREATOR = new Parcelable.Creator<EnterpriseEntity>() {
        @Override
        public EnterpriseEntity createFromParcel(Parcel source) {
            return new EnterpriseEntity(source);
        }

        @Override
        public EnterpriseEntity[] newArray(int size) {
            return new EnterpriseEntity[size];
        }
    };

}
