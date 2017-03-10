package com.qhzk.ciep.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/12/22.
 * 我要参会的下拉菜单选项
 */

public class MeetingEntity {

    /**
     * contract : 2
     * description : <p>全球才智论坛</p>
     * id : 1
     * meetingList : [{"address":"深圳市","bdelete":false,"checkcount":0,"confSection":1,"createtime":"2016-05-24 03:35:19","createtimeString":"2016-05-24 15:35:19","createuser":1,"endtime":"2015-07-26 12:00:00","endtimeString":"2015-07-26","feeneened":0,"id":"4028818754e1a0010154e1a191380005","joincount":0,"meetingCharacter":"01","picurl":"/images/banner3.png","rependtime":"2015-08-24 03:23:34","rependtimeString":"2015-08-24 15:23:34","repstarttime":"2015-05-10 03:23:31","repstarttimeString":"2015-05-10 15:23:31","starttime":"2015-07-24 12:00:00","starttimeString":"2015-07-24","title":"2014第十四届人才交流大会人才大数据论坛互联网2","updatetime":"2016-06-22 05:18:43","updatetimeString":"2016-06-22 17:18:43","updateuser":1},{"address":"深圳市","bdelete":false,"checkcount":0,"confSection":1,"createtime":"2016-05-24 03:35:19","createtimeString":"2016-05-24 15:35:19","createuser":1,"endtime":"2013-05-24 12:00:00","endtimeString":"2013-05-24","feeneened":300,"id":"4028818754e1a0010154e1a45c100002","joincount":0,"meetingCharacter":"03","picurl":"/images/banner3.png","rependtime":"2013-05-25 03:30:55","rependtimeString":"2013-05-25 15:30:55","repstarttime":"2013-05-17 03:30:52","repstarttimeString":"2013-05-17 15:30:52","starttime":"2013-05-24 12:00:00","starttimeString":"2013-05-24","title":"2013第十三届人才交流大会人才工业互联网","updatetime":"2016-06-22 05:19:40","updatetimeString":"2016-06-22 17:19:40","updateuser":1},{"address":"深圳市","bdelete":false,"checkcount":0,"confSection":1,"createtime":"2016-05-24 03:35:19","createtimeString":"2016-05-24 15:35:19","createuser":1,"endtime":"2011-05-24 12:00:00","endtimeString":"2011-05-24","feeneened":0,"id":"4028818754e1a0010154e1a45c100006","joincount":0,"meetingCharacter":"05","picurl":"/images/banner5.png","rependtime":"2011-05-25 03:30:55","rependtimeString":"2011-05-25 15:30:55","repstarttime":"2011-05-17 03:30:52","repstarttimeString":"2011-05-17 15:30:52","starttime":"2011-05-24 12:00:00","starttimeString":"2011-05-24","title":"2011第十二届人才交流大会人才工业互联网","updatetime":"2016-06-22 05:21:42","updatetimeString":"2016-06-22 17:21:42","updateuser":1},{"address":"深圳","bdelete":false,"confSection":1,"createtime":"2016-11-30 04:28:07","createtimeString":"2016-11-30 16:28:07","endtime":"2016-11-30 04:28:03","endtimeString":"2016-11-30","feeneened":0,"id":"8a8081ad58b455e90158b45919b30002","meetingCharacter":"04","rependtime":"2016-11-30 04:28:07","rependtimeString":"2016-11-30 16:28:07","repstarttime":"2016-11-30 04:28:05","repstarttimeString":"2016-11-30 16:28:05","starttime":"2016-11-30 04:28:01","starttimeString":"2016-11-30","title":"测试用"},{"address":"","bdelete":false,"confSection":1,"createtime":"2016-12-12 10:04:50","createtimeString":"2016-12-12 10:04:50","endtime":"2016-12-12 10:04:46","endtimeString":"2016-12-12","feeneened":0,"id":"8aadae8f58e7b4380158f0c68075000e","meetingCharacter":"115","rependtime":"2016-12-12 10:04:49","rependtimeString":"2016-12-12 10:04:49","repstarttime":"2016-12-12 10:04:47","repstarttimeString":"2016-12-12 10:04:47","starttime":"2016-12-12 10:04:44","starttimeString":"2016-12-12","title":"测试添加"}]
     * name : 全球才智论坛
     * phoneNum : 13247896452
     * sectionCharacter : AA
     * sortNumber : 0
     */
    public boolean isExpanded = false;
    private String contract;
    private String description;
    private int id;
    private String name;
    private String phoneNum;
    private String sectionCharacter;
    private int sortNumber;
    private List<MeetingListBean> meetingList;

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

    public List<MeetingListBean> getMeetingList() {
        return meetingList;
    }

    public void setMeetingList(List<MeetingListBean> meetingList) {
        this.meetingList = meetingList;
    }

    public static class MeetingListBean {
        /**
         * address : 深圳市
         * bdelete : false
         * checkcount : 0
         * confSection : 1
         * createtime : 2016-05-24 03:35:19
         * createtimeString : 2016-05-24 15:35:19
         * createuser : 1
         * endtime : 2015-07-26 12:00:00
         * endtimeString : 2015-07-26
         * feeneened : 0
         * id : 4028818754e1a0010154e1a191380005
         * joincount : 0
         * meetingCharacter : 01
         * picurl : /images/banner3.png
         * rependtime : 2015-08-24 03:23:34
         * rependtimeString : 2015-08-24 15:23:34
         * repstarttime : 2015-05-10 03:23:31
         * repstarttimeString : 2015-05-10 15:23:31
         * starttime : 2015-07-24 12:00:00
         * starttimeString : 2015-07-24
         * title : 2014第十四届人才交流大会人才大数据论坛互联网2
         * updatetime : 2016-06-22 05:18:43
         * updatetimeString : 2016-06-22 17:18:43
         * updateuser : 1
         */

        private String address;
        private boolean bdelete;
        private int checkcount;
        private int confSection;
        private String createtime;
        private String createtimeString;
        private int createuser;
        private String endtime;
        private String endtimeString;
        private int feeneened;
        private String id;
        private int joincount;
        private String meetingCharacter;
        private String picurl;
        private String rependtime;
        private String rependtimeString;
        private String repstarttime;
        private String repstarttimeString;
        private String starttime;
        private String starttimeString;
        private String title;
        private String updatetime;
        private String updatetimeString;
        private int updateuser;
        public boolean isChecked = false; //自己添加,用于判断是否被选中,我要参会
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

        public int getCheckcount() {
            return checkcount;
        }

        public void setCheckcount(int checkcount) {
            this.checkcount = checkcount;
        }

        public int getConfSection() {
            return confSection;
        }

        public void setConfSection(int confSection) {
            this.confSection = confSection;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getCreatetimeString() {
            return createtimeString;
        }

        public void setCreatetimeString(String createtimeString) {
            this.createtimeString = createtimeString;
        }

        public int getCreateuser() {
            return createuser;
        }

        public void setCreateuser(int createuser) {
            this.createuser = createuser;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public String getEndtimeString() {
            return endtimeString;
        }

        public void setEndtimeString(String endtimeString) {
            this.endtimeString = endtimeString;
        }

        public int getFeeneened() {
            return feeneened;
        }

        public void setFeeneened(int feeneened) {
            this.feeneened = feeneened;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getJoincount() {
            return joincount;
        }

        public void setJoincount(int joincount) {
            this.joincount = joincount;
        }

        public String getMeetingCharacter() {
            return meetingCharacter;
        }

        public void setMeetingCharacter(String meetingCharacter) {
            this.meetingCharacter = meetingCharacter;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public String getRependtime() {
            return rependtime;
        }

        public void setRependtime(String rependtime) {
            this.rependtime = rependtime;
        }

        public String getRependtimeString() {
            return rependtimeString;
        }

        public void setRependtimeString(String rependtimeString) {
            this.rependtimeString = rependtimeString;
        }

        public String getRepstarttime() {
            return repstarttime;
        }

        public void setRepstarttime(String repstarttime) {
            this.repstarttime = repstarttime;
        }

        public String getRepstarttimeString() {
            return repstarttimeString;
        }

        public void setRepstarttimeString(String repstarttimeString) {
            this.repstarttimeString = repstarttimeString;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getStarttimeString() {
            return starttimeString;
        }

        public void setStarttimeString(String starttimeString) {
            this.starttimeString = starttimeString;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public String getUpdatetimeString() {
            return updatetimeString;
        }

        public void setUpdatetimeString(String updatetimeString) {
            this.updatetimeString = updatetimeString;
        }

        public int getUpdateuser() {
            return updateuser;
        }

        public void setUpdateuser(int updateuser) {
            this.updateuser = updateuser;
        }
    }
}
