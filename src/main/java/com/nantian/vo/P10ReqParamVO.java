package com.nantian.vo;

import java.util.Map;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * P10数据请求中的 req_params 封装
 * @author badboyh20
 *
 */
public class P10ReqParamVO {
	@NotEmpty
	private String page_jump;
	private String rec_in_page;
	private Map<String, String> params;
	private String orderby;
	
	public P10ReqParamVO() {
		super();
	}
	public String getPage_jump() {
		return page_jump;
	}
	public void setPage_jump(String page_jump) {
		this.page_jump = page_jump;
	}
	public String getRec_in_page() {
		return rec_in_page;
	}
	public void setRec_in_page(String rec_in_page) {
		this.rec_in_page = rec_in_page;
	}
	public Map<String, String> getParams() {
		return params;
	}
	public void setParams(Map<String, String> params) {
		this.params = params;
	}
	public String getOrderby() {
		return orderby;
	}
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

}
