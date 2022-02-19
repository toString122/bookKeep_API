package com.liwj.keep.exception;

public class CustomException extends RuntimeException {
    private Integer code;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public CustomException(String msg) {
        this.msg = msg;
        this.code = 401;
    }

    public CustomException(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
    }
}
