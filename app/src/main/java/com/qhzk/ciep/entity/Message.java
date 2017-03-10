package com.qhzk.ciep.entity;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/30.
 * 我的消息
 */

public class Message {
    public int code;
    public int total;
    public ArrayList<RowsBean> rowsBeens;
    public String message;

    public static class RowsBean{
        public String bedelete;
        public String createtime;
        public String id ;
        public String recid;
        public String sendid;
        public MessageTextBean messageTextBean;

        @Override
        public String toString() {
            return "RowsBean{" +
                    "bedelete='" + bedelete + '\'' +
                    ", createtime='" + createtime + '\'' +
                    ", id='" + id + '\'' +
                    ", recid='" + recid + '\'' +
                    ", sendid='" + sendid + '\'' +
                    ", messageTextBean=" + messageTextBean +
                    '}';
        }

        public static class MessageTextBean{
            public String content;
            public String createtime;
            public String id;
            public String sent;
            public String title;

            @Override
            public String toString() {
                return "MessageTextBean{" +
                        "content='" + content + '\'' +
                        ", createtime='" + createtime + '\'' +
                        ", id='" + id + '\'' +
                        ", sent='" + sent + '\'' +
                        ", title='" + title + '\'' +
                        '}';
            }
        }
    }

    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", total=" + total +
                ", rowsBeens=" + rowsBeens +
                ", message='" + message + '\'' +
                '}';
    }
}
