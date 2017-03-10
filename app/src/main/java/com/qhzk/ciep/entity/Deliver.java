package com.qhzk.ciep.entity;

/**
 * Created by Administrator on 2016/12/28.
 * 已经投递的简历
 */

public class Deliver {

        /**
         * createTime : 2016-12-28 12:06:14
         * enterpriseId : 8aadae8f58f7f4540158fb4192800041
         * enterpriseInfo : {"bdelete":false,"contrct":"黄小姐 ","country":"中国","createDate":"2016-12-14 10:55:28","email":"109878777@qq.com","entsize":"5000~10000人","enttype":"上市公司","exhibited":false,"faxnum":"020-22388010","firstTime":1,"fpContent":"","fpTitle":"","id":"8aadae8f58f7f4540158fb4192800041","industry":"金融业","mobile":"18826225680","name":"平安普惠投资咨询有限公司","needReception":0,"postcode":"","profile":"安普惠做为中国平安集团的子公司，秉承\u201c信任就是力量\u201d的品牌理念，以创新的科技和卓越客户体验为广大小微型企业和个人客户提供更加优质的贷款服务，打造全球贷款客户信赖的消费金融品牌。2015年，平安信保业务、平安直通贷款业务、陆金所辖下的P2P小额信用贷款业务及富登融保业务，整合成立平安普惠金融业务集群，专注解决个人和小微型企业的消费金融需求。\n\n从2005年开始中国平安就于深圳开展个人消费金融业务；2007年成立信用保证保险事业部， 设立\"保证保险+银行贷款\"的业务模式，帮助个人及小微企业客户获取无抵押贷款；2010年设立平安直通贷，开展贷款产品的线上销售服务；2011年成立陆金所发展P2P业务；2014年收购富登融保，拓展小微企业市场；历经多年成长并经业务整合，最终呈现出了现在的平安普惠金融业务集群。","regionCity":"广东省","regionDistrict":"广州市","regionProv":"广东省","regsiterAddress":"","telephone":"","userId":"8aadae8f58f7f4540158fb3d8f5d003f","weburl":"http://haodai.pingan.com/pc/index.html"}
         * id : 8aadae8f594307500159439b63b90004
         * positionId : 8aadae8f58f7f4540158fb432ee40042
         * positionInfo : {"bdelete":false,"education":"本科","enterprise":{"bdelete":false,"contrct":"黄小姐 ","country":"中国","createDate":"2016-12-14 10:55:28","email":"109878777@qq.com","entsize":"5000~10000人","enttype":"上市公司","exhibited":false,"faxnum":"020-22388010","firstTime":1,"fpContent":"","fpTitle":"","id":"8aadae8f58f7f4540158fb4192800041","industry":"金融业","mobile":"18826225680","name":"平安普惠投资咨询有限公司","needReception":0,"postcode":"","profile":"安普惠做为中国平安集团的子公司，秉承\u201c信任就是力量\u201d的品牌理念，以创新的科技和卓越客户体验为广大小微型企业和个人客户提供更加优质的贷款服务，打造全球贷款客户信赖的消费金融品牌。2015年，平安信保业务、平安直通贷款业务、陆金所辖下的P2P小额信用贷款业务及富登融保业务，整合成立平安普惠金融业务集群，专注解决个人和小微型企业的消费金融需求。\n\n从2005年开始中国平安就于深圳开展个人消费金融业务；2007年成立信用保证保险事业部， 设立\"保证保险+银行贷款\"的业务模式，帮助个人及小微企业客户获取无抵押贷款；2010年设立平安直通贷，开展贷款产品的线上销售服务；2011年成立陆金所发展P2P业务；2014年收购富登融保，拓展小微企业市场；历经多年成长并经业务整合，最终呈现出了现在的平安普惠金融业务集群。","regionCity":"广东省","regionDistrict":"广州市","regionProv":"广东省","regsiterAddress":"","telephone":"","userId":"8aadae8f58f7f4540158fb3d8f5d003f","weburl":"http://haodai.pingan.com/pc/index.html"},"experience":"3年及以下","id":"8aadae8f58f7f4540158fb432ee40042","jobDesc":"1、负责公司产品的销售及推广；\n2、开拓新市场,发展新客户,建立媒介、渠道，增加产品销售范围；\n3、根据客户需求提供贷款方案，及时解决客户资金周转问题；\n4、管理维护客户关系以及客户间的长期合作计划；\n5、参加公司组织的各项销售活动；进行营销活动的推广、实施。\n","jobType":"全职","location":"凤凰北路41号华夏商务大厦","major":"经济学","nationality":"中国 ","num":10,"otherRequirement":"1、本科及以上学历，不限专业 ；优秀者可放宽至大专；\n2、有银行从业经验【信用卡、贷款、金融产品销售】优先考虑；有房地产、保险销售经验优先考虑；\n3、反应敏捷、表达能力强，具有较强的沟通能力及交际技巧，具有亲和力；\n4、具备一定的市场分析及判断能力，良好的客户服务意识；\n5、有责任心，能承受较大的工作压力； 有团队协作精神，善于挑战。","publishDate":"2016-12-14 10:57:13","salRange":"不限","title":"客户经理"}
         * resumeId : 8aadae8f593a900301593df8d9600002
         * userId : 8aadae8f58f7f4540158f81e64c20015
         */

        private String createTime;
        private String enterpriseId;
        private EnterpriseInfoBean enterpriseInfo;
        private String id;
        private String positionId;
        private PositionInfoBean positionInfo;
        private String resumeId;
        private String userId;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(String enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

        public EnterpriseInfoBean getEnterpriseInfo() {
            return enterpriseInfo;
        }

        public void setEnterpriseInfo(EnterpriseInfoBean enterpriseInfo) {
            this.enterpriseInfo = enterpriseInfo;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPositionId() {
            return positionId;
        }

        public void setPositionId(String positionId) {
            this.positionId = positionId;
        }

        public PositionInfoBean getPositionInfo() {
            return positionInfo;
        }

        public void setPositionInfo(PositionInfoBean positionInfo) {
            this.positionInfo = positionInfo;
        }

        public String getResumeId() {
            return resumeId;
        }

        public void setResumeId(String resumeId) {
            this.resumeId = resumeId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public static class EnterpriseInfoBean {
            /**
             * bdelete : false
             * contrct : 黄小姐
             * country : 中国
             * createDate : 2016-12-14 10:55:28
             * email : 109878777@qq.com
             * entsize : 5000~10000人
             * enttype : 上市公司
             * exhibited : false
             * faxnum : 020-22388010
             * firstTime : 1
             * fpContent :
             * fpTitle :
             * id : 8aadae8f58f7f4540158fb4192800041
             * industry : 金融业
             * mobile : 18826225680
             * name : 平安普惠投资咨询有限公司
             * needReception : 0
             * postcode :
             * profile : 安普惠做为中国平安集团的子公司，秉承“信任就是力量”的品牌理念，以创新的科技和卓越客户体验为广大小微型企业和个人客户提供更加优质的贷款服务，打造全球贷款客户信赖的消费金融品牌。2015年，平安信保业务、平安直通贷款业务、陆金所辖下的P2P小额信用贷款业务及富登融保业务，整合成立平安普惠金融业务集群，专注解决个人和小微型企业的消费金融需求。

             从2005年开始中国平安就于深圳开展个人消费金融业务；2007年成立信用保证保险事业部， 设立"保证保险+银行贷款"的业务模式，帮助个人及小微企业客户获取无抵押贷款；2010年设立平安直通贷，开展贷款产品的线上销售服务；2011年成立陆金所发展P2P业务；2014年收购富登融保，拓展小微企业市场；历经多年成长并经业务整合，最终呈现出了现在的平安普惠金融业务集群。
             * regionCity : 广东省
             * regionDistrict : 广州市
             * regionProv : 广东省
             * regsiterAddress :
             * telephone :
             * userId : 8aadae8f58f7f4540158fb3d8f5d003f
             * weburl : http://haodai.pingan.com/pc/index.html
             */

            private boolean bdelete;
            private String contrct;
            private String country;
            private String createDate;
            private String email;
            private String entsize;
            private String enttype;
            private boolean exhibited;
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

        public static class PositionInfoBean {
            /**
             * bdelete : false
             * education : 本科
             * enterprise : {"bdelete":false,"contrct":"黄小姐 ","country":"中国","createDate":"2016-12-14 10:55:28","email":"109878777@qq.com","entsize":"5000~10000人","enttype":"上市公司","exhibited":false,"faxnum":"020-22388010","firstTime":1,"fpContent":"","fpTitle":"","id":"8aadae8f58f7f4540158fb4192800041","industry":"金融业","mobile":"18826225680","name":"平安普惠投资咨询有限公司","needReception":0,"postcode":"","profile":"安普惠做为中国平安集团的子公司，秉承\u201c信任就是力量\u201d的品牌理念，以创新的科技和卓越客户体验为广大小微型企业和个人客户提供更加优质的贷款服务，打造全球贷款客户信赖的消费金融品牌。2015年，平安信保业务、平安直通贷款业务、陆金所辖下的P2P小额信用贷款业务及富登融保业务，整合成立平安普惠金融业务集群，专注解决个人和小微型企业的消费金融需求。\n\n从2005年开始中国平安就于深圳开展个人消费金融业务；2007年成立信用保证保险事业部， 设立\"保证保险+银行贷款\"的业务模式，帮助个人及小微企业客户获取无抵押贷款；2010年设立平安直通贷，开展贷款产品的线上销售服务；2011年成立陆金所发展P2P业务；2014年收购富登融保，拓展小微企业市场；历经多年成长并经业务整合，最终呈现出了现在的平安普惠金融业务集群。","regionCity":"广东省","regionDistrict":"广州市","regionProv":"广东省","regsiterAddress":"","telephone":"","userId":"8aadae8f58f7f4540158fb3d8f5d003f","weburl":"http://haodai.pingan.com/pc/index.html"}
             * experience : 3年及以下
             * id : 8aadae8f58f7f4540158fb432ee40042
             * jobDesc : 1、负责公司产品的销售及推广；
             2、开拓新市场,发展新客户,建立媒介、渠道，增加产品销售范围；
             3、根据客户需求提供贷款方案，及时解决客户资金周转问题；
             4、管理维护客户关系以及客户间的长期合作计划；
             5、参加公司组织的各项销售活动；进行营销活动的推广、实施。

             * jobType : 全职
             * location : 凤凰北路41号华夏商务大厦
             * major : 经济学
             * nationality : 中国
             * num : 10
             * otherRequirement : 1、本科及以上学历，不限专业 ；优秀者可放宽至大专；
             2、有银行从业经验【信用卡、贷款、金融产品销售】优先考虑；有房地产、保险销售经验优先考虑；
             3、反应敏捷、表达能力强，具有较强的沟通能力及交际技巧，具有亲和力；
             4、具备一定的市场分析及判断能力，良好的客户服务意识；
             5、有责任心，能承受较大的工作压力； 有团队协作精神，善于挑战。
             * publishDate : 2016-12-14 10:57:13
             * salRange : 不限
             * title : 客户经理
             */

            private boolean bdelete;
            private String education;
            private EnterpriseBean enterprise;
            private String experience;
            private String id;
            private String jobDesc;
            private String jobType;
            private String location;
            private String major;
            private String nationality;
            private int num;
            private String otherRequirement;
            private String publishDate;
            private String salRange;
            private String title;

            public boolean isBdelete() {
                return bdelete;
            }

            public void setBdelete(boolean bdelete) {
                this.bdelete = bdelete;
            }

            public String getEducation() {
                return education;
            }

            public void setEducation(String education) {
                this.education = education;
            }

            public EnterpriseBean getEnterprise() {
                return enterprise;
            }

            public void setEnterprise(EnterpriseBean enterprise) {
                this.enterprise = enterprise;
            }

            public String getExperience() {
                return experience;
            }

            public void setExperience(String experience) {
                this.experience = experience;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getJobDesc() {
                return jobDesc;
            }

            public void setJobDesc(String jobDesc) {
                this.jobDesc = jobDesc;
            }

            public String getJobType() {
                return jobType;
            }

            public void setJobType(String jobType) {
                this.jobType = jobType;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getMajor() {
                return major;
            }

            public void setMajor(String major) {
                this.major = major;
            }

            public String getNationality() {
                return nationality;
            }

            public void setNationality(String nationality) {
                this.nationality = nationality;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public String getOtherRequirement() {
                return otherRequirement;
            }

            public void setOtherRequirement(String otherRequirement) {
                this.otherRequirement = otherRequirement;
            }

            public String getPublishDate() {
                return publishDate;
            }

            public void setPublishDate(String publishDate) {
                this.publishDate = publishDate;
            }

            public String getSalRange() {
                return salRange;
            }

            public void setSalRange(String salRange) {
                this.salRange = salRange;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public static class EnterpriseBean {
                /**
                 * bdelete : false
                 * contrct : 黄小姐
                 * country : 中国
                 * createDate : 2016-12-14 10:55:28
                 * email : 109878777@qq.com
                 * entsize : 5000~10000人
                 * enttype : 上市公司
                 * exhibited : false
                 * faxnum : 020-22388010
                 * firstTime : 1
                 * fpContent :
                 * fpTitle :
                 * id : 8aadae8f58f7f4540158fb4192800041
                 * industry : 金融业
                 * mobile : 18826225680
                 * name : 平安普惠投资咨询有限公司
                 * needReception : 0
                 * postcode :
                 * profile : 安普惠做为中国平安集团的子公司，秉承“信任就是力量”的品牌理念，以创新的科技和卓越客户体验为广大小微型企业和个人客户提供更加优质的贷款服务，打造全球贷款客户信赖的消费金融品牌。2015年，平安信保业务、平安直通贷款业务、陆金所辖下的P2P小额信用贷款业务及富登融保业务，整合成立平安普惠金融业务集群，专注解决个人和小微型企业的消费金融需求。

                 从2005年开始中国平安就于深圳开展个人消费金融业务；2007年成立信用保证保险事业部， 设立"保证保险+银行贷款"的业务模式，帮助个人及小微企业客户获取无抵押贷款；2010年设立平安直通贷，开展贷款产品的线上销售服务；2011年成立陆金所发展P2P业务；2014年收购富登融保，拓展小微企业市场；历经多年成长并经业务整合，最终呈现出了现在的平安普惠金融业务集群。
                 * regionCity : 广东省
                 * regionDistrict : 广州市
                 * regionProv : 广东省
                 * regsiterAddress :
                 * telephone :
                 * userId : 8aadae8f58f7f4540158fb3d8f5d003f
                 * weburl : http://haodai.pingan.com/pc/index.html
                 */

                private boolean bdelete;
                private String contrct;
                private String country;
                private String createDate;
                private String email;
                private String entsize;
                private String enttype;
                private boolean exhibited;
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
