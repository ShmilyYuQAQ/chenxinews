package com.by.jetnews.data.request.domain;

public class Body {
    // 返回码
    private int code;
    // 数据
    private Object data;
    // 消息
    private String msg;

    public Body() {
    }

    public Body(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
