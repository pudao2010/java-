package com.qhzk.ciep.entity;

/**
 * Created by Administrator on 2016/12/23.
 * 岗位信息
 */

public class JobDetail {

        private boolean bdelete;
        private String id;
        private String title;
        private String salRange;
        private String experience;
        private String education;
        private String major;
        private int num;
        private String location;
        private String jobType;
        private String jobDesc;
        private String otherRequirement;
        private EnterpriseBean enterprise;
        private String publishDate;

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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSalRange() {
            return salRange;
        }

        public void setSalRange(String salRange) {
            this.salRange = salRange;
        }

        public String getExperience() {
            return experience;
        }

        public void setExperience(String experience) {
            this.experience = experience;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getJobType() {
            return jobType;
        }

        public void setJobType(String jobType) {
            this.jobType = jobType;
        }

        public String getJobDesc() {
            return jobDesc;
        }

        public void setJobDesc(String jobDesc) {
            this.jobDesc = jobDesc;
        }

        public String getOtherRequirement() {
            return otherRequirement;
        }

        public void setOtherRequirement(String otherRequirement) {
            this.otherRequirement = otherRequirement;
        }

        public EnterpriseBean getEnterprise() {
            return enterprise;
        }

        public void setEnterprise(EnterpriseBean enterprise) {
            this.enterprise = enterprise;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public static class EnterpriseBean {
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
            private String entDesc;
            private String createDate;
            private String logoImg;
            private String pdfUrl;
            private String userId;
            private String module;
            private String country;
            private String province;
            private String city;
            private String address;
            private String postcode;
            private String weburl;
            private String email;
            private String fpTitle;
            private String fpContent;
            private String regsiterAddress;
            private int firstTime;
            private String profile;
            private int needReception;

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

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getModule() {
                return module;
            }

            public void setModule(String module) {
                this.module = module;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getPostcode() {
                return postcode;
            }

            public void setPostcode(String postcode) {
                this.postcode = postcode;
            }

            public String getWeburl() {
                return weburl;
            }

            public void setWeburl(String weburl) {
                this.weburl = weburl;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getFpTitle() {
                return fpTitle;
            }

            public void setFpTitle(String fpTitle) {
                this.fpTitle = fpTitle;
            }

            public String getFpContent() {
                return fpContent;
            }

            public void setFpContent(String fpContent) {
                this.fpContent = fpContent;
            }

            public String getRegsiterAddress() {
                return regsiterAddress;
            }

            public void setRegsiterAddress(String regsiterAddress) {
                this.regsiterAddress = regsiterAddress;
            }

            public int getFirstTime() {
                return firstTime;
            }

            public void setFirstTime(int firstTime) {
                this.firstTime = firstTime;
            }

            public String getProfile() {
                return profile;
            }

            public void setProfile(String profile) {
                this.profile = profile;
            }

            public int getNeedReception() {
                return needReception;
            }

            public void setNeedReception(int needReception) {
                this.needReception = needReception;
            }
        }
}
