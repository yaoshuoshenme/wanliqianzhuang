package com.qzwl.common.result;

import java.io.Serializable;

public class R implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

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

    public R(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public R(int code, String msg,Object object) {
        this.code = code;
        this.msg = msg;
        this.data = object;
    }

    public R() {
    }


    public static R setOK(){
        return new R(0,"OK");
    }
    public static R setERROR(){
        return new R(1,"ERROR");
    }

}
