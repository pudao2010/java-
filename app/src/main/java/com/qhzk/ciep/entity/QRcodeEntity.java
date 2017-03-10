package com.qhzk.ciep.entity;

/**
 * Created by Thisdk on 2016/9/8.
 */

public class QRcodeEntity {

    private int cmd;
    private String action;
    private String params;
    private Object object;

    public int getCmd() {
        return cmd;
    }

    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
