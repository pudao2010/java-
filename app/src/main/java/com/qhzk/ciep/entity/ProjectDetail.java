package com.qhzk.ciep.entity;

/**
 * Created by Administrator on 2016/12/21.
 * 项目详情
 */

public class ProjectDetail {
    private String contacts;
    private String contactstitle;
    private String email;
    private String fax;
    private String id;
    private String introduction;
    private String mobile;
    private String name;
    private OrgBean org;
    private String orgintroduction;
    private String phone;
    private String releaseid;
    private String releasetime;
    private String sector;
    private String type;

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactstitle() {
        return contactstitle;
    }

    public void setContactstitle(String contactstitle) {
        this.contactstitle = contactstitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrgBean getOrg() {
        return org;
    }

    public void setOrg(OrgBean org) {
        this.org = org;
    }

    public String getOrgintroduction() {
        return orgintroduction;
    }

    public void setOrgintroduction(String orgintroduction) {
        this.orgintroduction = orgintroduction;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReleaseid() {
        return releaseid;
    }

    public void setReleaseid(String releaseid) {
        this.releaseid = releaseid;
    }

    public String getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(String releasetime) {
        this.releasetime = releasetime;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class OrgBean {

        private boolean bdelete;
        private String contrct;
        private String country;
        private String createDate;
        private String email;
        private String entsize;
        private String enttype;
        private String faxnum;
        private int firstTime;
        private String fpContent;
        private String fpTitle;
        private String id;
        private String industry;
        private String mobile;
        private String name;
        private int needReception;
        private String postcode;
        private String profile;
        private String regionCity;
        private String regionDistrict;
        private String regionProv;
        private String regsiterAddress;
        private String telephone;
        private String userId;
        private String weburl;

        public boolean isBdelete() {
            return bdelete;
        }

        public void setBdelete(boolean bdelete) {
            this.bdelete = bdelete;
        }

        public String getContrct() {
            return contrct;
        }

        public void setContrct(String contrct) {
            this.contrct = contrct;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEntsize() {
            return entsize;
        }

        public void setEntsize(String entsize) {
            this.entsize = entsize;
        }

        public String getEnttype() {
            return enttype;
        }

        public void setEnttype(String enttype) {
            this.enttype = enttype;
        }

        public String getFaxnum() {
            return faxnum;
        }

        public void setFaxnum(String faxnum) {
            this.faxnum = faxnum;
        }

        public int getFirstTime() {
            return firstTime;
        }

        public void setFirstTime(int firstTime) {
            this.firstTime = firstTime;
        }

        public String getFpContent() {
            return fpContent;
        }

        public void setFpContent(String fpContent) {
            this.fpContent = fpContent;
        }

        public String getFpTitle() {
            return fpTitle;
        }

        public void setFpTitle(String fpTitle) {
            this.fpTitle = fpTitle;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIndustry() {
            return industry;
        }

        public void setIndustry(String industry) {
            this.industry = industry;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNeedReception() {
            return needReception;
        }

        public void setNeedReception(int needReception) {
            this.needReception = needReception;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
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

        public String getRegionProv() {
            return regionProv;
        }

        public void setRegionProv(String regionProv) {
            this.regionProv = regionProv;
        }

        public String getRegsiterAddress() {
            return regsiterAddress;
        }

        public void setRegsiterAddress(String regsiterAddress) {
            this.regsiterAddress = regsiterAddress;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getWeburl() {
            return weburl;
        }

        public void setWeburl(String weburl) {
            this.weburl = weburl;
        }
    }

    @Override
    public String toString() {
        return "ProjectDetail{" +
                "contacts='" + contacts + '\'' +
                ", contactstitle='" + contactstitle + '\'' +
                ", email='" + email + '\'' +
                ", fax='" + fax + '\'' +
                ", id='" + id + '\'' +
                ", introduction='" + introduction + '\'' +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", org=" + org +
                ", orgintroduction='" + orgintroduction + '\'' +
                ", phone='" + phone + '\'' +
                ", releaseid='" + releaseid + '\'' +
                ", releasetime='" + releasetime + '\'' +
                ", sector='" + sector + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
