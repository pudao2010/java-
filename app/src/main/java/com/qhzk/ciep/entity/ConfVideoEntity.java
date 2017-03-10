package com.qhzk.ciep.entity;

/**
 * Created by pucheng on 2017/1/12.
 * 新闻中心大会视频
 */

public class ConfVideoEntity {
//    "id": "8aadae8f574fe5a00157655346a50011",
//    "title": "教育优先发展要建设人力资源强国",
//    "subtitle": "",
//    "videopath": "/video/djg.mp4",
//    "previewpath": "/upload/201609/o_1atikpsel1tff18tr1m6iodr7s6c.jpg",
//    "video_poster": "",
//    "create_date": "2016-12-10",
//    "description": "中国梦关键的就是人才、时间。教育改革纲要重点提出了改革的内容，首先提出的就是人才培养模式的改变。人才培养不是仅仅重学历，更强调知识、技能、能力等方面。我们国家发展到今天，人才培养模式要改变。另一方面，考试招生制度要改革。这也就是发展纲要中改革的第一项任务。",
//    "indexShow": "1",
//    "type":

    private String id;
    private String title;
    private String subtitle;
    private String videopath;
    private String previewpath;
    private String video_poster;
    private String create_date;
    private String description;
    private String indexShow;
    private String type;

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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getVideopath() {
        return videopath;
    }

    public void setVideopath(String videopath) {
        this.videopath = videopath;
    }

    public String getPreviewpath() {
        return previewpath;
    }

    public void setPreviewpath(String previewpath) {
        this.previewpath = previewpath;
    }

    public String getVideo_poster() {
        return video_poster;
    }

    public void setVideo_poster(String video_poster) {
        this.video_poster = video_poster;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIndexShow() {
        return indexShow;
    }

    public void setIndexShow(String indexShow) {
        this.indexShow = indexShow;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
