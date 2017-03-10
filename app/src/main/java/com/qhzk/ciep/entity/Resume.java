package com.qhzk.ciep.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/12/27.
 * 我的简历
 */

public class Resume {

    /**
     * msg : success
     * resume : {"createDate":"2016-12-27 17:25:02","educationList":[{"degree":"博士","description":"蛤蛤蛤","enddate":"2014-07-01","id":"8aadae8f593e4f1501593f46c903002f","major":"计算机","resumeid":"8aadae8f593a900301593df8d9600002","school":"清华大学","startdate":"2010-09-10"},{"degree":"博士","description":"蛤蛤蛤","enddate":"2014-07-01","id":"8aadae8f593e4f1501593f4713e80030","major":"计算机","resumeid":"8aadae8f593a900301593df8d9600002","school":"清华大学","startdate":"2010-09-01"},{"degree":"博士","description":"蛤蛤蛤","enddate":"2014-07-01","id":"8aadae8f593e4f1501593f4718460031","major":"计算机","resumeid":"8aadae8f593a900301593df8d9600002","school":"清华大学","startdate":"2010-09-01"},{"degree":"博士","description":"蛤蛤蛤","enddate":"2014-07-01","id":"8aadae8f593e4f1501593f471ae20032","major":"计算机","resumeid":"8aadae8f593a900301593df8d9600002","school":"清华大学","startdate":"2010-09-01"},{"degree":"博士","description":"蛤蛤蛤","enddate":"2014-07-01","id":"8aadae8f593e4f1501593f471d4b0033","major":"计算机","resumeid":"8aadae8f593a900301593df8d9600002","school":"清华大学","startdate":"2010-09-01"},{"degree":"博士","description":"蛤蛤蛤","enddate":"2014-07-01","id":"8aadae8f593f502201593f6520010003","major":"计算机","resumeid":"8aadae8f593a900301593df8d9600002","school":"背景大学","startdate":"2010-09-01"}],"id":"8aadae8f593a900301593df8d9600002","jobPreferences":[{"dutytime":"1周以内","id":"8aadae8f593f502201593f9d30e30016","industry":"传媒行业","jobtype":"轻松","location":"北京市","position":"主席","resumeid":"8aadae8f593a900301593df8d9600002","selfdesc":"哈哈哈,我很乐观","targetsalary":"10000"}],"name":"刘德华","userid":"8aadae8f58f7f4540158f81e64c20015","workExperienceList":[{"company":"腾讯","comsize":"10000","comtype":"科技","department":"研发部","description":"一个人的是","enddate":"2015-12-10","id":"8aadae8f593f502201593f9712720014","industry":"开发","jobtype":"哈哈","position":"总监","resumeid":"8aadae8f593a900301593df8d9600002","startdate":"2014-10-10"}]}
     * code : 0
     */

    private String msg;
    private ResumeBean resume;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResumeBean getResume() {
        return resume;
    }

    public void setResume(ResumeBean resume) {
        this.resume = resume;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResumeBean {
        /**
         * createDate : 2016-12-27 17:25:02
         * educationList : [{"degree":"博士","description":"蛤蛤蛤","enddate":"2014-07-01","id":"8aadae8f593e4f1501593f46c903002f","major":"计算机","resumeid":"8aadae8f593a900301593df8d9600002","school":"清华大学","startdate":"2010-09-10"},{"degree":"博士","description":"蛤蛤蛤","enddate":"2014-07-01","id":"8aadae8f593e4f1501593f4713e80030","major":"计算机","resumeid":"8aadae8f593a900301593df8d9600002","school":"清华大学","startdate":"2010-09-01"},{"degree":"博士","description":"蛤蛤蛤","enddate":"2014-07-01","id":"8aadae8f593e4f1501593f4718460031","major":"计算机","resumeid":"8aadae8f593a900301593df8d9600002","school":"清华大学","startdate":"2010-09-01"},{"degree":"博士","description":"蛤蛤蛤","enddate":"2014-07-01","id":"8aadae8f593e4f1501593f471ae20032","major":"计算机","resumeid":"8aadae8f593a900301593df8d9600002","school":"清华大学","startdate":"2010-09-01"},{"degree":"博士","description":"蛤蛤蛤","enddate":"2014-07-01","id":"8aadae8f593e4f1501593f471d4b0033","major":"计算机","resumeid":"8aadae8f593a900301593df8d9600002","school":"清华大学","startdate":"2010-09-01"},{"degree":"博士","description":"蛤蛤蛤","enddate":"2014-07-01","id":"8aadae8f593f502201593f6520010003","major":"计算机","resumeid":"8aadae8f593a900301593df8d9600002","school":"背景大学","startdate":"2010-09-01"}]
         * id : 8aadae8f593a900301593df8d9600002
         * jobPreferences : [{"dutytime":"1周以内","id":"8aadae8f593f502201593f9d30e30016","industry":"传媒行业","jobtype":"轻松","location":"北京市","position":"主席","resumeid":"8aadae8f593a900301593df8d9600002","selfdesc":"哈哈哈,我很乐观","targetsalary":"10000"}]
         * name : 刘德华
         * userid : 8aadae8f58f7f4540158f81e64c20015
         * workExperienceList : [{"company":"腾讯","comsize":"10000","comtype":"科技","department":"研发部","description":"一个人的是","enddate":"2015-12-10","id":"8aadae8f593f502201593f9712720014","industry":"开发","jobtype":"哈哈","position":"总监","resumeid":"8aadae8f593a900301593df8d9600002","startdate":"2014-10-10"}]
         */

        private String createDate;
        private String id;
        private String name;
        private String userid;
        private List<EducationListBean> educationList;
        private List<JobPreferencesBean> jobPreferences;
        private List<WorkExperienceListBean> workExperienceList;

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
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

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public List<EducationListBean> getEducationList() {
            return educationList;
        }

        public void setEducationList(List<EducationListBean> educationList) {
            this.educationList = educationList;
        }

        public List<JobPreferencesBean> getJobPreferences() {
            return jobPreferences;
        }

        public void setJobPreferences(List<JobPreferencesBean> jobPreferences) {
            this.jobPreferences = jobPreferences;
        }

        public List<WorkExperienceListBean> getWorkExperienceList() {
            return workExperienceList;
        }

        public void setWorkExperienceList(List<WorkExperienceListBean> workExperienceList) {
            this.workExperienceList = workExperienceList;
        }

        public static class EducationListBean implements Serializable{
            /**
             * degree : 博士
             * description : 蛤蛤蛤
             * enddate : 2014-07-01
             * id : 8aadae8f593e4f1501593f46c903002f
             * major : 计算机
             * resumeid : 8aadae8f593a900301593df8d9600002
             * school : 清华大学
             * startdate : 2010-09-10
             */

            private String degree;
            private String description;
            private String enddate;
            private String id;
            private String major;
            private String resumeid;
            private String school;
            private String startdate;

            public String getDegree() {
                return degree;
            }

            public void setDegree(String degree) {
                this.degree = degree;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getEnddate() {
                return enddate;
            }

            public void setEnddate(String enddate) {
                this.enddate = enddate;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMajor() {
                return major;
            }

            public void setMajor(String major) {
                this.major = major;
            }

            public String getResumeid() {
                return resumeid;
            }

            public void setResumeid(String resumeid) {
                this.resumeid = resumeid;
            }

            public String getSchool() {
                return school;
            }

            public void setSchool(String school) {
                this.school = school;
            }

            public String getStartdate() {
                return startdate;
            }

            public void setStartdate(String startdate) {
                this.startdate = startdate;
            }
        }

        public static class JobPreferencesBean {
            /**
             * dutytime : 1周以内
             * id : 8aadae8f593f502201593f9d30e30016
             * industry : 传媒行业
             * jobtype : 轻松
             * location : 北京市
             * position : 主席
             * resumeid : 8aadae8f593a900301593df8d9600002
             * selfdesc : 哈哈哈,我很乐观
             * targetsalary : 10000
             */

            private String dutytime;
            private String id;
            private String industry;
            private String jobtype;
            private String location;
            private String position;
            private String resumeid;
            private String selfdesc;
            private String targetsalary;

            public String getDutytime() {
                return dutytime;
            }

            public void setDutytime(String dutytime) {
                this.dutytime = dutytime;
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

            public String getJobtype() {
                return jobtype;
            }

            public void setJobtype(String jobtype) {
                this.jobtype = jobtype;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getResumeid() {
                return resumeid;
            }

            public void setResumeid(String resumeid) {
                this.resumeid = resumeid;
            }

            public String getSelfdesc() {
                return selfdesc;
            }

            public void setSelfdesc(String selfdesc) {
                this.selfdesc = selfdesc;
            }

            public String getTargetsalary() {
                return targetsalary;
            }

            public void setTargetsalary(String targetsalary) {
                this.targetsalary = targetsalary;
            }
        }

        public static class WorkExperienceListBean implements Serializable{
            /**
             * company : 腾讯
             * comsize : 10000
             * comtype : 科技
             * department : 研发部
             * description : 一个人的是
             * enddate : 2015-12-10
             * id : 8aadae8f593f502201593f9712720014
             * industry : 开发
             * jobtype : 哈哈
             * position : 总监
             * resumeid : 8aadae8f593a900301593df8d9600002
             * startdate : 2014-10-10
             */

            private String company;
            private String comsize;
            private String comtype;
            private String department;
            private String description;
            private String enddate;
            private String id;
            private String industry;
            private String jobtype;
            private String position;
            private String resumeid;
            private String startdate;

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getComsize() {
                return comsize;
            }

            public void setComsize(String comsize) {
                this.comsize = comsize;
            }

            public String getComtype() {
                return comtype;
            }

            public void setComtype(String comtype) {
                this.comtype = comtype;
            }

            public String getDepartment() {
                return department;
            }

            public void setDepartment(String department) {
                this.department = department;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getEnddate() {
                return enddate;
            }

            public void setEnddate(String enddate) {
                this.enddate = enddate;
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

            public String getJobtype() {
                return jobtype;
            }

            public void setJobtype(String jobtype) {
                this.jobtype = jobtype;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getResumeid() {
                return resumeid;
            }

            public void setResumeid(String resumeid) {
                this.resumeid = resumeid;
            }

            public String getStartdate() {
                return startdate;
            }

            public void setStartdate(String startdate) {
                this.startdate = startdate;
            }
        }
    }
}
