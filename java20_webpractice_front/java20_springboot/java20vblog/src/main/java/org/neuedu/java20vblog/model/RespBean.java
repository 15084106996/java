package org.neuedu.java20vblog.model;

public class RespBean {
    private Integer code;
    private String msg;
    private Object obj;

    private RespBean(Integer code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    private RespBean() {
    }

    public static RespBean success(Integer code, String msg) {
        return new RespBean(code,msg,null);
    }
    public static RespBean success(Integer code, String msg, Object obj) {
        return new RespBean(code,msg,obj);
    }
    public static RespBean error(Integer code, String msg) {
        return new RespBean(code,msg,null);
    }
    public static RespBean error(Integer code, String msg, Object obj) {
        return new RespBean(code,msg,obj);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
