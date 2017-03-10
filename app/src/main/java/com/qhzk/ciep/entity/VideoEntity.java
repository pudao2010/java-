package com.qhzk.ciep.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Thisdk on 2016/9/8.
 */

public class VideoEntity implements Parcelable {

    private boolean bdelete;
    private String id;
    private String title;
    private String videopath;
    private String previewpath;
    private String subtitle;
    private String description;
    private String crateDate;

    public boolean isBdelete() {
        return bdelete;
    }

    public void setBdelete(boolean bdelete) {
        this.bdelete = bdelete;
    }

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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCrateDate() {
        return crateDate;
    }

    public void setCrateDate(String crateDate) {
        this.crateDate = crateDate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.bdelete ? (byte) 1 : (byte) 0);
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.videopath);
        dest.writeString(this.previewpath);
        dest.writeString(this.subtitle);
        dest.writeString(this.description);
        dest.writeString(this.crateDate);
    }

    public VideoEntity() {
    }

    protected VideoEntity(Parcel in) {
        this.bdelete = in.readByte() != 0;
        this.id = in.readString();
        this.title = in.readString();
        this.videopath = in.readString();
        this.previewpath = in.readString();
        this.subtitle = in.readString();
        this.description = in.readString();
        this.crateDate = in.readString();
    }

    public static final Parcelable.Creator<VideoEntity> CREATOR = new Parcelable.Creator<VideoEntity>() {
        @Override
        public VideoEntity createFromParcel(Parcel source) {
            return new VideoEntity(source);
        }

        @Override
        public VideoEntity[] newArray(int size) {
            return new VideoEntity[size];
        }
    };

    @Override
    public String toString() {
        return "VideoEntity{" +
                "bdelete=" + bdelete +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", videopath='" + videopath + '\'' +
                ", previewpath='" + previewpath + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", description='" + description + '\'' +
                ", crateDate='" + crateDate + '\'' +
                '}';
    }
}
