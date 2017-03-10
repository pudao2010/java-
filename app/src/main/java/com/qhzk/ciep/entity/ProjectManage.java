package com.qhzk.ciep.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/30.
 * 发布项目
 */

public class ProjectManage implements Serializable{

    /**
     * msg : success
     * total : 3
     * code : 0
     * rows : [{"cifCust":{"bdelete":"0","brecommend":"0","custlevelcode":"50","id":"8aadae8f58f7dc720158f7e0097e0001","joindate":"2016-12-13 19:10:04","joindateString":"2016-12-13 19:10:04","logintime":"2016-12-30 12:05:33","logintimeString":"2016-12-30 12:05:33","mobile":"","password":"e9c358491a39cca63e5589fa439780ff","recommendno":0,"status":"0","usercode":"pucn2010@163.com","usertype":"P"},"contacts":"王健林","contactstitle":"歌手","email":"12@qq.com","fax":"075512345678","id":"8aadae8f594dbb4701594dfd6c120004","introduction":"两个亿的项目","mobile":"13212345678","name":"两个亿","orgintroduction":"大公司","phone":"0755123456768","releaseid":"8aadae8f58f7dc720158f7e0097e0001","releasetime":"2016-12-30","sector":"建筑业","type":"技术需求"},{"cifCust":{"$ref":"$.rows[0].cifCust"},"contacts":"周杰伦","contactstitle":"歌手","email":"12@qq.com","fax":"075512345678","id":"8aadae8f594dbb4701594de917f40003","introduction":"一个亿的项目","mobile":"13212345678","name":"一个亿","orgintroduction":"小公司","phone":"0755123456768","releaseid":"8aadae8f58f7dc720158f7e0097e0001","releasetime":"2016-12-30","sector":"建筑业","type":"技术需求"},{"cifCust":{"$ref":"$.rows[0].cifCust"},"contacts":"","contactstitle":"","email":"","fax":"","id":"8aadae8f594dbb4701594de7afff0002","introduction":"","mobile":"","name":"","orgintroduction":"","phone":"","releaseid":"8aadae8f58f7dc720158f7e0097e0001","releasetime":"2016-12-30","sector":"","type":""}]
     */

        /**
         * cifCust : {"bdelete":"0","brecommend":"0","custlevelcode":"50","id":"8aadae8f58f7dc720158f7e0097e0001","joindate":"2016-12-13 19:10:04","joindateString":"2016-12-13 19:10:04","logintime":"2016-12-30 12:05:33","logintimeString":"2016-12-30 12:05:33","mobile":"","password":"e9c358491a39cca63e5589fa439780ff","recommendno":0,"status":"0","usercode":"pucn2010@163.com","usertype":"P"}
         * contacts : 王健林
         * contactstitle : 歌手
         * email : 12@qq.com
         * fax : 075512345678
         * id : 8aadae8f594dbb4701594dfd6c120004
         * introduction : 两个亿的项目
         * mobile : 13212345678
         * name : 两个亿
         * orgintroduction : 大公司
         * phone : 0755123456768
         * releaseid : 8aadae8f58f7dc720158f7e0097e0001
         * releasetime : 2016-12-30
         * sector : 建筑业
         * type : 技术需求
         */

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

        public static class CifCustBean implements Serializable{
            /**
             * bdelete : 0
             * brecommend : 0
             * custlevelcode : 50
             * id : 8aadae8f58f7dc720158f7e0097e0001
             * joindate : 2016-12-13 19:10:04
             * joindateString : 2016-12-13 19:10:04
             * logintime : 2016-12-30 12:05:33
             * logintimeString : 2016-12-30 12:05:33
             * mobile :
             * password : e9c358491a39cca63e5589fa439780ff
             * recommendno : 0
             * status : 0
             * usercode : pucn2010@163.com
             * usertype : P
             */

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
