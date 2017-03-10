package com.qhzk.ciep.entity;

import java.util.List;

/**
 * Created by pucheng on 2017/1/4.
 * 大会通知
 */

public class Notice {

        /**
         * rows : [{"id":"8aadae8f58f5edfd0158f5f264a50003","title":"第十五届国际人才交流大会 明年4月在深举办","typecode":"confnotice","introduction":"第十五届中国国际人才交流大会将于2017年4月15日到16日在深圳举办。昨天上午，大会组委会第一次会议在深圳召开，组委会主任、人力资源和社会保障部副部长、国家外国专家局局长张建国，组委会主任、深圳市市长许勤出席会议并讲话。","orderx":"150","createtime":"2016-12-13","viewtimes":"0"},{"id":"8aadae8f5738a17e01573afabdb50003","title":"中国国际人才交流大会 参会服务收费标准","typecode":"confnotice","introduction":"以下收费包含大会期间的住宿、用餐、接送机（火车）及限定时间内酒店往返会场穿梭巴士服务、会展资料（参展证件、会务手册、大会导览图、国际人才交流杂志）、大会咨询服务等。","orderx":"120","createtime":"2016-09-18","viewtimes":"0"},{"id":"8aadae8f5738a17e01573aed960f0002","title":"(境外培训合作机构)欢迎参加中国国际人才交流大会","typecode":"confnotice","introduction":"本次大会的详细会务信息请登陆大会官方网站进行网上查询，并与大会组委会北京工作组联系。 会务、布展、费用标准等相关信息由大会组委会统一安排。","orderx":"110","createtime":"2016-09-18","viewtimes":"0"},{"id":"8aadae8f59687391015968c641270030","title":"关于召开第十四届中国国际人才交流大会的通知","typecode":"confnotice","introduction":"第十四届中国国际人才交流大会主要内容包括15个板块，涵盖展览洽谈、人才招聘、项目对接、高峰论坛、人才培训、专题研讨等各项内容。","orderx":"100","createtime":"2017-01-04","viewtimes":"0"},{"id":"8aadae8f58e2df9f0158e6933f310001","title":"第十五届中国国际人才交流大会国际职业教育与高技能人才专馆邀请函","typecode":"confnotice","introduction":"第十五届中国国际人才交流大会特别设置国际职业教育与高技能人才专馆。依托中国国际人才交流大会这个国际化、国家级的平台，全面落实\u201c中国制造2025\u201d发展战略，弘扬工匠精神，打造技能强国。","createtime":"2016-12-10","viewtimes":"0"},{"id":"8aadae8f5738a17e01573b26b7a10004","title":"第十四届中国国际人才交流大会 人才大数据论坛邀请函","typecode":"confnotice","introduction":"大会同期举办\u201c人才大数据论坛\u201d，该论坛由国家外专局和深圳市政府主办，国家外国专家局国外人才信息研究中心、深圳市人力资源和社会保障局和深圳市海云天投资控股集团等承办。","createtime":"2016-09-18","viewtimes":"0"},{"id":"8aadae8f5738a17e01573b272fe70005","title":"第十四届中国国际人才交流大会《中国国际创新城市发展通知》","typecode":"confnotice","introduction":"本次大会以中国国际创新城市发展为主题，从创新城市发展的主要驱动要素、重要载体、重点领域、关键技术等方面，使得国际创新合作和国际技术转移项目落地更具战略意义和实际成效。","createtime":"2016-09-18","viewtimes":"0"}]
         * total : 7
         */

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
            /**
             * id : 8aadae8f58f5edfd0158f5f264a50003
             * title : 第十五届国际人才交流大会 明年4月在深举办
             * typecode : confnotice
             * introduction : 第十五届中国国际人才交流大会将于2017年4月15日到16日在深圳举办。昨天上午，大会组委会第一次会议在深圳召开，组委会主任、人力资源和社会保障部副部长、国家外国专家局局长张建国，组委会主任、深圳市市长许勤出席会议并讲话。
             * orderx : 150
             * createtime : 2016-12-13
             * viewtimes : 0
             */

            private String id;
            private String title;
            private String typecode;
            private String introduction;
            private String orderx;
            private String createtime;
            private String viewtimes;

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

            public String getTypecode() {
                return typecode;
            }

            public void setTypecode(String typecode) {
                this.typecode = typecode;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public String getOrderx() {
                return orderx;
            }

            public void setOrderx(String orderx) {
                this.orderx = orderx;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getViewtimes() {
                return viewtimes;
            }

            public void setViewtimes(String viewtimes) {
                this.viewtimes = viewtimes;
            }
        }
}
