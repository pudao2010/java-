package com.qhzk.ciep.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/12/30.
 */

public class SearchNewEntity {

    private int code;
    private String msg;
    private NewsBean news;
    private EnterpriseBean enterprise;

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

    public NewsBean getNews() {
        return news;
    }

    public void setNews(NewsBean news) {
        this.news = news;
    }

    public EnterpriseBean getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(EnterpriseBean enterprise) {
        this.enterprise = enterprise;
    }

    public static class NewsBean {

        private int total;
        private List<RowsBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {

            private String author;
            private String authorid;
            private boolean bdelete;
            private String comefrom;
            private String content;
            private long createtime;
            private String createtimeString;
            private String id;
            private String introduction;
            private int inxshow;
            private int ntype;
            private String pcimg;
            private String title;
            private String typecode;
            private long updatetime;
            private String updatetimeString;
            private int viewtimes;
            private int orderx;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getAuthorid() {
                return authorid;
            }

            public void setAuthorid(String authorid) {
                this.authorid = authorid;
            }

            public boolean isBdelete() {
                return bdelete;
            }

            public void setBdelete(boolean bdelete) {
                this.bdelete = bdelete;
            }

            public String getComefrom() {
                return comefrom;
            }

            public void setComefrom(String comefrom) {
                this.comefrom = comefrom;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public long getCreatetime() {
                return createtime;
            }

            public void setCreatetime(long createtime) {
                this.createtime = createtime;
            }

            public String getCreatetimeString() {
                return createtimeString;
            }

            public void setCreatetimeString(String createtimeString) {
                this.createtimeString = createtimeString;
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

            public int getInxshow() {
                return inxshow;
            }

            public void setInxshow(int inxshow) {
                this.inxshow = inxshow;
            }

            public int getNtype() {
                return ntype;
            }

            public void setNtype(int ntype) {
                this.ntype = ntype;
            }

            public String getPcimg() {
                return pcimg;
            }

            public void setPcimg(String pcimg) {
                this.pcimg = pcimg;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTypecode() {
                return typecode;
            }

            public void setTypecode(String typecode) {
                this.typecode = typecode;
            }

            public long getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(long updatetime) {
                this.updatetime = updatetime;
            }

            public String getUpdatetimeString() {
                return updatetimeString;
            }

            public void setUpdatetimeString(String updatetimeString) {
                this.updatetimeString = updatetimeString;
            }

            public int getViewtimes() {
                return viewtimes;
            }

            public void setViewtimes(int viewtimes) {
                this.viewtimes = viewtimes;
            }

            public int getOrderx() {
                return orderx;
            }

            public void setOrderx(int orderx) {
                this.orderx = orderx;
            }
        }
    }

    public static class EnterpriseBean {
        /**
         * total : 0
         * rows : []
         */

        private int total;
        private List<EntRowsBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<?> getRows() {
            return rows;
        }

        public void setRows(List<EntRowsBean> rows) {
            this.rows = rows;
        }

        public static class EntRowsBean{

        }
    }
}
