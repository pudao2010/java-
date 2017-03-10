package com.qhzk.ciep.entity;

/**
 * Created by Administrator on 2016/12/26.
 * 单位信息页面 对应的 项目对接
 */

public class ProjectDock {
        private CifCustBean cifCust;
        private String contacts;
        private String contactstitle;
        private String email;
        private String fax;
        private String id;
        private String introduction;
        private String mobile;
        private String name;
        private String orgintroduction;
        private String phone;
        private String releaseid;
        private String releasetime;
        private String sector;
        private String type;

        public CifCustBean getCifCust() {
            return cifCust;
        }

        public void setCifCust(CifCustBean cifCust) {
            this.cifCust = cifCust;
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

        public static class CifCustBean {

            private String bdelete;
            private String brecommend;
            private String custlevelcode;
            private String id;
            private String joindate;
            private String joindateString;
            private String logintime;
            private String logintimeString;
            private String mobile;
            private String password;
            private int recommendno;
            private String status;
            private String usercode;
            private String usertype;

            public String getBdelete() {
                return bdelete;
            }

            public void setBdelete(String bdelete) {
                this.bdelete = bdelete;
            }

            public String getBrecommend() {
                return brecommend;
            }

            public void setBrecommend(String brecommend) {
                this.brecommend = brecommend;
            }

            public String getCustlevelcode() {
                return custlevelcode;
            }

            public void setCustlevelcode(String custlevelcode) {
                this.custlevelcode = custlevelcode;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getJoindate() {
                return joindate;
            }

            public void setJoindate(String joindate) {
                this.joindate = joindate;
            }

            public String getJoindateString() {
                return joindateString;
            }

            public void setJoindateString(String joindateString) {
                this.joindateString = joindateString;
            }

            public String getLogintime() {
                return logintime;
            }

            public void setLogintime(String logintime) {
                this.logintime = logintime;
            }

            public String getLogintimeString() {
                return logintimeString;
            }

            public void setLogintimeString(String logintimeString) {
                this.logintimeString = logintimeString;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public int getRecommendno() {
                return recommendno;
            }

            public void setRecommendno(int recommendno) {
                this.recommendno = recommendno;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getUsercode() {
                return usercode;
            }

            public void setUsercode(String usercode) {
                this.usercode = usercode;
            }

            public String getUsertype() {
                return usertype;
            }

            public void setUsertype(String usertype) {
                this.usertype = usertype;
            }
        }
}
