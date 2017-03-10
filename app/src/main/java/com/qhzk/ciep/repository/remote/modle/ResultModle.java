package com.qhzk.ciep.repository.remote.modle;

/**
 * Created by Thisdk on 2016/4/11.
 * 请求结果返回模型
 */
public class ResultModle<T> {

    private int code = 0;
    private String msg;
    private T data;
//    private int total;
    private T rows;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

//    public int getTotal() {
//        return total;
//    }
//
//    public void setTotal(int total) {
//        this.total = total;
//    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }
}
