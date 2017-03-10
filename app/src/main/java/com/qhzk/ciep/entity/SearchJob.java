package com.qhzk.ciep.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 * 岗位搜索
 */

public class SearchJob {

        /**
         * pageNo : 1
         * pageSize : 20
         * orderBy :
         * order : asc
         * autoCount : true
         * result : [{"bdelete":false,"id":"8aadae8f593f502201593f6f08f10007","title":"Java工程师","salRange":"面议","experience":"3年及以下","education":"本科","major":"工学","industry":"信息传输、软件和信息技术服务业","num":4,"location":"苏州","ageRange":"","jobType":"全职","jobDesc":"1、大专及以上学历，计算机相关专业\n2、会Java编程，Sqlserver等数据库和相关编程技术；\n3、会使用Eclipse、PL/SQL Developer等开发工具，了解XML基本知识；\n4、会基于常用框架如：Struts2、Spring、Hibernate等进行应用开发；\n5、了解掌握网站基础开发如CSS、HTML5、JavaScript等；\n6、了解数据库(Oracle/SQLServer)存储过程编写和SQL优化能力；\n7、沟通能力强，愿意服从项目任务安排；\n8、抗压能力强，性格开朗，能适应高强度的劳动；\n9、会Android开发的，优先考虑。\n","otherRequirement":"1、熟练掌握J2EE架构；\n2、精通JAVA三层架构开发模式；\n3、了解SOA架构及其实现方法；\n4、熟悉Eclipse插件及相关技术；\n5、熟悉Eclipse开发工具，熟悉Ajax、Struts、Spring、Hibernate开发框架，熟悉JMS和Web Service的开发及Java多线程开发；\n6、熟练使用至少一种J2EE基础框架体系；\n7、熟悉主流数据库系统及其相关应用开发 。","enterprise":{"bdelete":false,"id":"8aadae8f593e4f1501593f0a56ca0025","name":"苏州超维地球科学研究开发有限公司","contrct":"珂先生","mobile":"13886577996","telephone":"","faxnum":"0512-68249770","industry":"信息传输、软件和信息技术服务业","enttype":"合资","entsize":"500~1000人","regionProv":"中国","regionCity":"江苏省","regionDistrict":"苏州市","createDate":"2016-12-27 14:50:44","pdfUrl":"","userId":"8aadae8f593e4f1501593f07247a0023","country":"中国","postcode":"","weburl":"","email":"10658840@qq.com","fpTitle":"","fpContent":"","regsiterAddress":"","firstTime":1,"profile":"苏州超维地球科学研究开发有限公司成立于2003年1月8日，是江苏省软件企业和苏州市技术先进型服务企业。公司是国内最早从事GIS,GPS,RS领域的研究和相关应用开发的公司之一。公司的产品包含了3S相关的基础引擎和覆盖国土，测绘，水利，防灾，农业，物流，智慧城市等领域的多种解决方案。\n\n公司拥有自主知识产权的车载导航数据处理技术，常年为奔驰，宝马，沃尔沃，三菱等十多家世界知名车厂的一百多个车种提供覆盖全球范围的车载导航数据的开发，处理和检证业务。公司还与中国科学院、南京大学、武汉大学等院校携手合作，在现代物流，电子商务等领域为相关行业客户提供全方位的解决方案，系统集成等服务。","needReception":0,"exhibited":false},"nationality":"中国","publishDate":"2016-12-27 16:39:18"}]
         * totalCount : 1
         * asc : true
         * orderBySetted : false
         * totalPages : 1
         * hasNext : false
         * nextPage : 1
         * hasPre : false
         * prePage : 1
         * first : 1
         */

        private int pageNo;
        private int pageSize;
        private String orderBy;
        private String order;
        private boolean autoCount;
        private int totalCount;
        private boolean asc;
        private boolean orderBySetted;
        private int totalPages;
        private boolean hasNext;
        private int nextPage;
        private boolean hasPre;
        private int prePage;
        private int first;
        private List<ResultBean> result;

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public String getOrderBy() {
            return orderBy;
        }

        public void setOrderBy(String orderBy) {
            this.orderBy = orderBy;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public boolean isAutoCount() {
            return autoCount;
        }

        public void setAutoCount(boolean autoCount) {
            this.autoCount = autoCount;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public boolean isAsc() {
            return asc;
        }

        public void setAsc(boolean asc) {
            this.asc = asc;
        }

        public boolean isOrderBySetted() {
            return orderBySetted;
        }

        public void setOrderBySetted(boolean orderBySetted) {
            this.orderBySetted = orderBySetted;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public boolean isHasPre() {
            return hasPre;
        }

        public void setHasPre(boolean hasPre) {
            this.hasPre = hasPre;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * bdelete : false
             * id : 8aadae8f593f502201593f6f08f10007
             * title : Java工程师
             * salRange : 面议
             * experience : 3年及以下
             * education : 本科
             * major : 工学
             * industry : 信息传输、软件和信息技术服务业
             * num : 4
             * location : 苏州
             * ageRange :
             * jobType : 全职
             * jobDesc : 1、大专及以上学历，计算机相关专业
             2、会Java编程，Sqlserver等数据库和相关编程技术；
             3、会使用Eclipse、PL/SQL Developer等开发工具，了解XML基本知识；
             4、会基于常用框架如：Struts2、Spring、Hibernate等进行应用开发；
             5、了解掌握网站基础开发如CSS、HTML5、JavaScript等；
             6、了解数据库(Oracle/SQLServer)存储过程编写和SQL优化能力；
             7、沟通能力强，愿意服从项目任务安排；
             8、抗压能力强，性格开朗，能适应高强度的劳动；
             9、会Android开发的，优先考虑。

             * otherRequirement : 1、熟练掌握J2EE架构；
             2、精通JAVA三层架构开发模式；
             3、了解SOA架构及其实现方法；
             4、熟悉Eclipse插件及相关技术；
             5、熟悉Eclipse开发工具，熟悉Ajax、Struts、Spring、Hibernate开发框架，熟悉JMS和Web Service的开发及Java多线程开发；
             6、熟练使用至少一种J2EE基础框架体系；
             7、熟悉主流数据库系统及其相关应用开发 。
             * enterprise : {"bdelete":false,"id":"8aadae8f593e4f1501593f0a56ca0025","name":"苏州超维地球科学研究开发有限公司","contrct":"珂先生","mobile":"13886577996","telephone":"","faxnum":"0512-68249770","industry":"信息传输、软件和信息技术服务业","enttype":"合资","entsize":"500~1000人","regionProv":"中国","regionCity":"江苏省","regionDistrict":"苏州市","createDate":"2016-12-27 14:50:44","pdfUrl":"","userId":"8aadae8f593e4f1501593f07247a0023","country":"中国","postcode":"","weburl":"","email":"10658840@qq.com","fpTitle":"","fpContent":"","regsiterAddress":"","firstTime":1,"profile":"苏州超维地球科学研究开发有限公司成立于2003年1月8日，是江苏省软件企业和苏州市技术先进型服务企业。公司是国内最早从事GIS,GPS,RS领域的研究和相关应用开发的公司之一。公司的产品包含了3S相关的基础引擎和覆盖国土，测绘，水利，防灾，农业，物流，智慧城市等领域的多种解决方案。\n\n公司拥有自主知识产权的车载导航数据处理技术，常年为奔驰，宝马，沃尔沃，三菱等十多家世界知名车厂的一百多个车种提供覆盖全球范围的车载导航数据的开发，处理和检证业务。公司还与中国科学院、南京大学、武汉大学等院校携手合作，在现代物流，电子商务等领域为相关行业客户提供全方位的解决方案，系统集成等服务。","needReception":0,"exhibited":false}
             * nationality : 中国
             * publishDate : 2016-12-27 16:39:18
             */

            private boolean bdelete;
            private String id;
            private String title;
            private String salRange;
            private String experience;
            private String education;
            private String major;
            private String industry;
            private int num;
            private String location;
            private String ageRange;
            private String jobType;
            private String jobDesc;
            private String otherRequirement;
            private EnterpriseBean enterprise;
            private String nationality;
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

            public String getIndustry() {
                return industry;
            }

            public void setIndustry(String industry) {
                this.industry = industry;
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

            public String getAgeRange() {
                return ageRange;
            }

            public void setAgeRange(String ageRange) {
                this.ageRange = ageRange;
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

            public String getNationality() {
                return nationality;
            }

            public void setNationality(String nationality) {
                this.nationality = nationality;
            }

            public String getPublishDate() {
                return publishDate;
            }

            public void setPublishDate(String publishDate) {
                this.publishDate = publishDate;
            }

            public static class EnterpriseBean {
                /**
                 * bdelete : false
                 * id : 8aadae8f593e4f1501593f0a56ca0025
                 * name : 苏州超维地球科学研究开发有限公司
                 * contrct : 珂先生
                 * mobile : 13886577996
                 * telephone :
                 * faxnum : 0512-68249770
                 * industry : 信息传输、软件和信息技术服务业
                 * enttype : 合资
                 * entsize : 500~1000人
                 * regionProv : 中国
                 * regionCity : 江苏省
                 * regionDistrict : 苏州市
                 * createDate : 2016-12-27 14:50:44
                 * pdfUrl :
                 * userId : 8aadae8f593e4f1501593f07247a0023
                 * country : 中国
                 * postcode :
                 * weburl :
                 * email : 10658840@qq.com
                 * fpTitle :
                 * fpContent :
                 * regsiterAddress :
                 * firstTime : 1
                 * profile : 苏州超维地球科学研究开发有限公司成立于2003年1月8日，是江苏省软件企业和苏州市技术先进型服务企业。公司是国内最早从事GIS,GPS,RS领域的研究和相关应用开发的公司之一。公司的产品包含了3S相关的基础引擎和覆盖国土，测绘，水利，防灾，农业，物流，智慧城市等领域的多种解决方案。

                 公司拥有自主知识产权的车载导航数据处理技术，常年为奔驰，宝马，沃尔沃，三菱等十多家世界知名车厂的一百多个车种提供覆盖全球范围的车载导航数据的开发，处理和检证业务。公司还与中国科学院、南京大学、武汉大学等院校携手合作，在现代物流，电子商务等领域为相关行业客户提供全方位的解决方案，系统集成等服务。
                 * needReception : 0
                 * exhibited : false
                 */

                private boolean bdelete;
                private String id;
                private String name;
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
                private String createDate;
                private String pdfUrl;
                private String userId;
                private String country;
                private String postcode;
                private String weburl;
                private String email;
                private String fpTitle;
                private String fpContent;
                private String regsiterAddress;
                private int firstTime;
                private String profile;
                private int needReception;
                private boolean exhibited;

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

                public String getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(String createDate) {
                    this.createDate = createDate;
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

                public String getCountry() {
                    return country;
                }

                public void setCountry(String country) {
                    this.country = country;
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

                public boolean isExhibited() {
                    return exhibited;
                }

                public void setExhibited(boolean exhibited) {
                    this.exhibited = exhibited;
                }
            }
        }
}
