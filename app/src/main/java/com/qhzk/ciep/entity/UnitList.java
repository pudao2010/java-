package com.qhzk.ciep.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/12/24.
 * 大会介绍模块的参展名单
 */

public class UnitList {
        private String address;
        private boolean bdelete;
        private String city;
        private String contrct;
        private String country;
        private String createDate;
        private String email;
        private String ename;
        private String entDesc;
        private String entsize;
        private String enttype;
        private int exYears;
        private boolean exhibited;
        private String faxnum;
        private int firstTime;
        private String fpContent;
        private String fpTitle;
        private String id;
        private String industry;
        private String logoImg;
        private String mobile;
        private String module;
        private String name;
        private int needReception;
        private String pdfUrl;
        private String postcode;
        private String profile;
        private String province;
        private String regionCity;
        private String regionDistrict;
        private String regionProv;
        private String regsiterAddress;
        private String telephone;
        private String userId;
        private String weburl;
        private List<AreaExhibitorsListBean> areaExhibitorsList;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public boolean isBdelete() {
            return bdelete;
        }

        public void setBdelete(boolean bdelete) {
            this.bdelete = bdelete;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
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

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getEntDesc() {
            return entDesc;
        }

        public void setEntDesc(String entDesc) {
            this.entDesc = entDesc;
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

        public int getExYears() {
            return exYears;
        }

        public void setExYears(int exYears) {
            this.exYears = exYears;
        }

        public boolean isExhibited() {
            return exhibited;
        }

        public void setExhibited(boolean exhibited) {
            this.exhibited = exhibited;
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

        public String getLogoImg() {
            return logoImg;
        }

        public void setLogoImg(String logoImg) {
            this.logoImg = logoImg;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getModule() {
            return module;
        }

        public void setModule(String module) {
            this.module = module;
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

        public String getPdfUrl() {
            return pdfUrl;
        }

        public void setPdfUrl(String pdfUrl) {
            this.pdfUrl = pdfUrl;
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

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
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

        public List<AreaExhibitorsListBean> getAreaExhibitorsList() {
            return areaExhibitorsList;
        }

        public void setAreaExhibitorsList(List<AreaExhibitorsListBean> areaExhibitorsList) {
            this.areaExhibitorsList = areaExhibitorsList;
        }

        public static class AreaExhibitorsListBean {
            private AreaBean area;
            private String areaid;
            private int audit;
            private String createtime;
            private String description;
            private String enterpriseid;
            private String id;
            private int paystatus;
            private String position;
            private int price;
            private SectionBean section;
            private String sectionid;
            private int specialcount;
            private int threefourcount;
            private int threethreecount;
            private int threetwocount;

            public AreaBean getArea() {
                return area;
            }

            public void setArea(AreaBean area) {
                this.area = area;
            }

            public String getAreaid() {
                return areaid;
            }

            public void setAreaid(String areaid) {
                this.areaid = areaid;
            }

            public int getAudit() {
                return audit;
            }

            public void setAudit(int audit) {
                this.audit = audit;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getEnterpriseid() {
                return enterpriseid;
            }

            public void setEnterpriseid(String enterpriseid) {
                this.enterpriseid = enterpriseid;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getPaystatus() {
                return paystatus;
            }

            public void setPaystatus(int paystatus) {
                this.paystatus = paystatus;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public SectionBean getSection() {
                return section;
            }

            public void setSection(SectionBean section) {
                this.section = section;
            }

            public String getSectionid() {
                return sectionid;
            }

            public void setSectionid(String sectionid) {
                this.sectionid = sectionid;
            }

            public int getSpecialcount() {
                return specialcount;
            }

            public void setSpecialcount(int specialcount) {
                this.specialcount = specialcount;
            }

            public int getThreefourcount() {
                return threefourcount;
            }

            public void setThreefourcount(int threefourcount) {
                this.threefourcount = threefourcount;
            }

            public int getThreethreecount() {
                return threethreecount;
            }

            public void setThreethreecount(int threethreecount) {
                this.threethreecount = threethreecount;
            }

            public int getThreetwocount() {
                return threetwocount;
            }

            public void setThreetwocount(int threetwocount) {
                this.threetwocount = threetwocount;
            }

            public static class AreaBean {

                private String description;
                private String id;
                private String name;
                private String sectionid;
                private int specialprice;
                private int threefourprice;
                private int threethreeprice;
                private int threetwoprice;

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
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

                public String getSectionid() {
                    return sectionid;
                }

                public void setSectionid(String sectionid) {
                    this.sectionid = sectionid;
                }

                public int getSpecialprice() {
                    return specialprice;
                }

                public void setSpecialprice(int specialprice) {
                    this.specialprice = specialprice;
                }

                public int getThreefourprice() {
                    return threefourprice;
                }

                public void setThreefourprice(int threefourprice) {
                    this.threefourprice = threefourprice;
                }

                public int getThreethreeprice() {
                    return threethreeprice;
                }

                public void setThreethreeprice(int threethreeprice) {
                    this.threethreeprice = threethreeprice;
                }

                public int getThreetwoprice() {
                    return threetwoprice;
                }

                public void setThreetwoprice(int threetwoprice) {
                    this.threetwoprice = threetwoprice;
                }
            }

            public static class SectionBean {
                private String contract;
                private String description;
                private int id;
                private String name;
                private String phoneNum;
                private String sectionCharacter;
                private int sortNumber;

                public String getContract() {
                    return contract;
                }

                public void setContract(String contract) {
                    this.contract = contract;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPhoneNum() {
                    return phoneNum;
                }

                public void setPhoneNum(String phoneNum) {
                    this.phoneNum = phoneNum;
                }

                public String getSectionCharacter() {
                    return sectionCharacter;
                }

                public void setSectionCharacter(String sectionCharacter) {
                    this.sectionCharacter = sectionCharacter;
                }

                public int getSortNumber() {
                    return sortNumber;
                }

                public void setSortNumber(int sortNumber) {
                    this.sortNumber = sortNumber;
                }
            }
        }

}
