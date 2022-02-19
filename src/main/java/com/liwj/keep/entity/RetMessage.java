package com.liwj.keep.entity;

import lombok.Data;
import org.apache.http.HttpStatus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018-07-17.
 */
@Data
public class RetMessage extends HashMap<String, Object> implements Serializable {
    private boolean result;
    private String msg;
    private Object data;


    private static final long serialVersionUID = 1L;

    public RetMessage() {
        put("code", 0);
        put("result", true);
        put("msg", "success");
    }

    public static RetMessage error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static RetMessage error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static RetMessage error(int code, String msg) {
        RetMessage r = new RetMessage();
        r.put("code", code);
        r.put("result", true);
        r.put("msg", msg);
        return r;
    }

    public static RetMessage ok(String msg) {
        RetMessage r = new RetMessage();
        r.put("msg", msg);
        return r;
    }

    public static RetMessage ok(Map<String, Object> map) {
        RetMessage r = new RetMessage();
        r.putAll(map);
        return r;
    }

    public static RetMessage ok() {
        return new RetMessage();
    }

    @Override
    public RetMessage put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public void setData(Object value) {
        super.put("data", value);
    }
    public void setResult(boolean result) {
        super.put("result", result);
    }

}
