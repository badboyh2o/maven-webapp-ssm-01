package com.nantian.vo;


/**
 * 返回值
 * @param <T>
 */
public class RespVO<T> {
    private String code;
    private String msg;
    private T result;
 
    /**
     * 新建 ResultVO
     * @param <T>
     * @return
     */
    public static <T> RespVO<T> getNewResultVO() {
        return new RespVO<T>();
    }
    
    // 构造器
    public RespVO() {
        super();
    }
    public RespVO(String code) {
        super();
        this.code = code;
    }
    public RespVO(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public RespVO(String code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
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
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
}
