package com.qhzk.ciep.entity;

/**
 * Created by pucheng on 2017/2/16.
 *
 */

public class AreaDetailBean {

    private int code;
    private String msg;
    private AreaBean area;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public AreaBean getArea() {
        return area;
    }

    public void setArea(AreaBean area) {
        this.area = area;
    }

    public static class AreaBean {

        private String description;
        private String detail;
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

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
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
}
