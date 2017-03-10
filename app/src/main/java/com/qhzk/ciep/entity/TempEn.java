package com.qhzk.ciep.entity;

/**
 * Created by Administrator on 2016/12/21.
 * 项目详情
 */

public class TempEn {

    /**
     * msg : 查询成功
     * code : 0
     * project : {"contacts":"finony","contactstitle":"总经理","email":"548742121@qq.com","fax":"0513-89905566","id":"8a8081a757fa7ce40157fa94c4650002","introduction":"海工辅助船（AHTS、PSV、WMV等）存在空间紧张、系统复杂的特点，因此生产设计时设备、管系、电缆布置极为困难，通过进行数字化设计制造关键技术研究，采用设备管系单元模块化等合理工艺手段，力争将分段预舾装率提高到90%以上，同时将下水完整性提高到80%以上，从而提高制造效率，降低制造成本，缩短制造周期。","mobile":"15500279564","name":"数字化设计制造关键技术研究","org":{"bdelete":false,"contrct":"finony","country":"中国","createDate":"2016-12-15 02:08:56","email":"548742121@qq.com","entsize":"150~500人","enttype":"非盈利机构","faxnum":"0513-89905566","firstTime":1,"fpContent":"","fpTitle":"","id":"8aadae8f58fdb60c015901190ea10036","industry":"交通运输、仓储和邮政业","mobile":"15500279564","name":"南通帮润海洋工程装备有限公司","needReception":0,"postcode":"","profile":"南通帮润海洋工程装备有限公司注册资金1亿，共有职工212人，其中技术人员39人，占18.4%。公司占地约50万平方米。\n\n公司已建立海洋工程装备技术研发中心，已获得3项实用新型专利授权，13项发明专利授权，主要生产海上风电服务平台、海洋工程辅助船舶、特种工程船、海洋工程特种装备等产品。","regionCity":"江苏省","regionDistrict":"南通市","regionProv":"中国","regsiterAddress":"","telephone":"","userId":"8aadae8f58fdb60c015901163b790034","weburl":"www.br088.com.cn"},"orgintroduction":"南通帮润海洋工程装备有限公司注册资金1亿，共有职工212人，其中技术人员39人，占18.4%。公司占地约50万平方米。\n\n公司已建立海洋工程装备技术研发中心，已获得3项实用新型专利授权，13项发明专利授权，主要生产海上风电服务平台、海洋工程辅助船舶、特种工程船、海洋工程特种装备等产品。","phone":"0513-89905566","releaseid":"8aadae8f58fdb60c015901163b790034","releasetime":"2016-12-21","sector":"交通运输、仓储和邮政业","type":"技术需求"}
     */

    private String msg;
    private int code;
    private ProjectBean project;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ProjectBean getProject() {
        return project;
    }

    public void setProject(ProjectBean project) {
        this.project = project;
    }

    public static class ProjectBean {
        private String contacts;
        private String contactstitle;
        private String email;
        private String fax;
        private String id;
        private String introduction;
        private String mobile;
        private String name;
        private OrgBean org;                // 企业
        private PersonBean person;          // 个人
        private String orgintroduction;
        private String phone;
        private String releaseid;
        private String releasetime;
        private String sector;
        private String type;

        public PersonBean getPerson() {
            return person;
        }

        public void setPerson(PersonBean person) {
            this.person = person;
        }

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

        //        "person": {
//                    "bdelete": false,
//                    "comIndustry": "农、林、牧、渔业",
//                    "comSize": "少于50人",
//                    "comType": "外资（欧美）",
//                    "company": "深圳国际人才大数据科技有限公司",
//                    "createDate": 1483671379000,
//                    "educationlevel": "本科",
//                    "email": "645778875@qq.com",
//                    "gender": "男",
//                    "graduated": "深圳大学",
//                    "groupId": "",
//                    "id": "8aadae8f5968739101596de36e9e0053",
//                    "major": "哲学",
//                    "name": "金元宝",
//                    "nationality": "中国",
//                    "needReception": 0,
//                    "phoneNum": "13128986986",
//                    "position": "web前端工程师",
//                    "purpose": "寻找工作,项目对接",
//                    "userId": "8aadae8f5968739101596937722e004a"
//        }
        public static class PersonBean {
            public String comIndustry;
            public String comSize;
            public String comType;
            public String company;
            public String createDate;
            public String educationlevel;
            public String email;
            public String gender;
            public String graduated;
            public String groupId;
            public String major;
            public String name;
            public String nationality;
            public int needReception;  //是否需要接待  0不要  1要
            public String phoneNum;
            public String position;
            public String purpose;
            public String userId;
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
    }
}
