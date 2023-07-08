package com.example.bugawayme.retrofitResponseData;

public class JsonRootBean {

    private int code;
    private String msg;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "JsonRootBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
