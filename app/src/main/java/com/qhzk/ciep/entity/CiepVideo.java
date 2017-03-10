package com.qhzk.ciep.entity;

import java.util.List;

/**
 * Created by pucheng on 2017/1/12.
 */

public class CiepVideo {

    /**
     * code : 0
     * msg : SUCCESS
     * data : {"rows":[{"id":"2","title":"大数据助力人才评价机制改革","subtitle":"","videopath":"/video/wujiang.mp4","previewpath":"/upload/201609/o_1at2k6fmn7cv1i7g1pfa6n5ebqc.jpg","video_poster":"","create_date":"2016-12-15","description":"人才要精准，要能够符合个性化。这次中央改革首先提出分类制度，分类评价。研究分类评价，不同的人要整理采集不同的信息。大数据运用恰恰是维系社会承认的驱动，是用数据积累出来的，积累的叫信赖能力。","indexShow":"1","type":"主题发言"},{"id":"1","title":"推动政府管制 提供人才之间交流","subtitle":"","videopath":"/video/uma.mp4","previewpath":"/upload/201609/o_1at04fq92b64aap31gehg0c.jpg","video_poster":"","create_date":"2016-12-15","description":"作为一个政府管制管理中心，目的是要在中国以及全球范围内去提供更多的人才之间的交流，特别是我们这个中心的主要任务是推动中国政府官员和美国政府官员之间更好的合作，我们也非常高兴在一些国际协会上发挥了重要的作用。","indexShow":"1","type":"主题发言"},{"id":"8aadae8f574fe5a001576f61a7a90016","title":"落实主体责任，完善监管机制","subtitle":"","videopath":"/video/xkc.mp4","previewpath":"/upload/201609/o_1atnm43favvu1v2hloh1p051vr2c.jpg","video_poster":"/upload/201609/o_1atnm4a9s1b7k11dvkil153u13jfl.jpg","create_date":"2016-12-15","description":"通过科学规范引领科学发展，把海绵城市的理念融入到城市的各个领域各个层次，既要保护治理，恢复并科学的利用原有水系，又要科学规划生态的新水系，改善居民的生活条件。","indexShow":"1","type":"主题发言"},{"id":"8aadae8f574fe5a0015765409f630010","title":"建设现代化、国际化创新型城市","subtitle":"","videopath":"/video/lz.mp4","previewpath":"/upload/201609/o_1atik1a6qfia18blf0u1rt31j3al.jpg","video_poster":"","create_date":"2016-12-15","description":"创新是发展的第一动力，而人才是创新的第一资源。所以要建创新型城市，首先要用创新驱动发展。最关键的是要用人才驱动创新，支撑创新。 深圳的人才在某些领域是非常辉煌的，甚至有些领域在全国处于领先的地位。","indexShow":"1","type":"网络直播"},{"id":"3","title":"利用国际人才大数据服务引智事业发展","subtitle":"","videopath":"/video/lm.mp4","previewpath":"images/IMG_1655.JPG","video_poster":"","create_date":"2016-12-15","description":"积极利用大数据技术将促进引智信息资源的深度整合和开发利用，也将提升政府治理能力、提升引智信息化水平、提高公共服务水平，更有效地利用国际人才智力资源服务国家创新发展。","indexShow":"1","type":"网络直播"},{"id":"8aadae8f574fe5a00157655346a50011","title":"教育优先发展要建设人力资源强国","subtitle":"","videopath":"/video/djg.mp4","previewpath":"/upload/201609/o_1atikpsel1tff18tr1m6iodr7s6c.jpg","video_poster":"","create_date":"2016-12-10","description":"中国梦关键的就是人才、时间。教育改革纲要重点提出了改革的内容，首先提出的就是人才培养模式的改变。人才培养不是仅仅重学历，更强调知识、技能、能力等方面。我们国家发展到今天，人才培养模式要改变。另一方面，考试招生制度要改革。这也就是发展纲要中改革的第一项任务。","indexShow":"1","type":"网络直播"}],"total":6}
     */

    private int code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * rows : [{"id":"2","title":"大数据助力人才评价机制改革","subtitle":"","videopath":"/video/wujiang.mp4","previewpath":"/upload/201609/o_1at2k6fmn7cv1i7g1pfa6n5ebqc.jpg","video_poster":"","create_date":"2016-12-15","description":"人才要精准，要能够符合个性化。这次中央改革首先提出分类制度，分类评价。研究分类评价，不同的人要整理采集不同的信息。大数据运用恰恰是维系社会承认的驱动，是用数据积累出来的，积累的叫信赖能力。","indexShow":"1","type":"主题发言"},{"id":"1","title":"推动政府管制 提供人才之间交流","subtitle":"","videopath":"/video/uma.mp4","previewpath":"/upload/201609/o_1at04fq92b64aap31gehg0c.jpg","video_poster":"","create_date":"2016-12-15","description":"作为一个政府管制管理中心，目的是要在中国以及全球范围内去提供更多的人才之间的交流，特别是我们这个中心的主要任务是推动中国政府官员和美国政府官员之间更好的合作，我们也非常高兴在一些国际协会上发挥了重要的作用。","indexShow":"1","type":"主题发言"},{"id":"8aadae8f574fe5a001576f61a7a90016","title":"落实主体责任，完善监管机制","subtitle":"","videopath":"/video/xkc.mp4","previewpath":"/upload/201609/o_1atnm43favvu1v2hloh1p051vr2c.jpg","video_poster":"/upload/201609/o_1atnm4a9s1b7k11dvkil153u13jfl.jpg","create_date":"2016-12-15","description":"通过科学规范引领科学发展，把海绵城市的理念融入到城市的各个领域各个层次，既要保护治理，恢复并科学的利用原有水系，又要科学规划生态的新水系，改善居民的生活条件。","indexShow":"1","type":"主题发言"},{"id":"8aadae8f574fe5a0015765409f630010","title":"建设现代化、国际化创新型城市","subtitle":"","videopath":"/video/lz.mp4","previewpath":"/upload/201609/o_1atik1a6qfia18blf0u1rt31j3al.jpg","video_poster":"","create_date":"2016-12-15","description":"创新是发展的第一动力，而人才是创新的第一资源。所以要建创新型城市，首先要用创新驱动发展。最关键的是要用人才驱动创新，支撑创新。 深圳的人才在某些领域是非常辉煌的，甚至有些领域在全国处于领先的地位。","indexShow":"1","type":"网络直播"},{"id":"3","title":"利用国际人才大数据服务引智事业发展","subtitle":"","videopath":"/video/lm.mp4","previewpath":"images/IMG_1655.JPG","video_poster":"","create_date":"2016-12-15","description":"积极利用大数据技术将促进引智信息资源的深度整合和开发利用，也将提升政府治理能力、提升引智信息化水平、提高公共服务水平，更有效地利用国际人才智力资源服务国家创新发展。","indexShow":"1","type":"网络直播"},{"id":"8aadae8f574fe5a00157655346a50011","title":"教育优先发展要建设人力资源强国","subtitle":"","videopath":"/video/djg.mp4","previewpath":"/upload/201609/o_1atikpsel1tff18tr1m6iodr7s6c.jpg","video_poster":"","create_date":"2016-12-10","description":"中国梦关键的就是人才、时间。教育改革纲要重点提出了改革的内容，首先提出的就是人才培养模式的改变。人才培养不是仅仅重学历，更强调知识、技能、能力等方面。我们国家发展到今天，人才培养模式要改变。另一方面，考试招生制度要改革。这也就是发展纲要中改革的第一项任务。","indexShow":"1","type":"网络直播"}]
         * total : 6
         */

        private int total;
        private List<ConfVideoEntity> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ConfVideoEntity> getRows() {
            return rows;
        }

        public void setRows(List<ConfVideoEntity> rows) {
            this.rows = rows;
        }

    }
}
