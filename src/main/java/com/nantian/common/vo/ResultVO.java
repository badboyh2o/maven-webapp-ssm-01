package com.nantian.common.vo;


/**
 * ajax 接口的返回结果封装类
 *
 * @param <T>
 */
public class ResultVO<T> {
    private String code;
    private String msg;
    private T data;
 
    /**
     * 新建 ResultVO
     * @param <T>
     * @return
     */
    public static <T> ResultVO<T> getNewResultVO() {
        return new ResultVO<T>();
    }
    
    // 构造器
    public ResultVO() {
        super();
    }
    public ResultVO(String code) {
        super();
        this.code = code;
    }
    public ResultVO(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public ResultVO(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    
    // getter/setter
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
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
    
}
