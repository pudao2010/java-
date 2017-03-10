package com.qhzk.ciep.entity;

/**
 * Created by Administrator on 2016/12/24.
 * 2016年12月24日18:11:02
 * 往届回顾--展商名录
 */

public class Exhibitor {

        private String contacts;
        private String createTime;
        private String id;
        private String name;
        private String phone;

        public String getContacts() {
            return contacts;
        }

        public void setContacts(String contacts) {
            this.contacts = contacts;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

    @Override
    public String toString() {
        return "Exhibitor{" +
                "contacts='" + contacts + '\'' +
                ", createTime='" + createTime + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
