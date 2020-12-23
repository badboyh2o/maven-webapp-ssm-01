package com.nantian.vo;

import java.util.List;
import java.util.Map;

/**
 * P10接口的数据封装
 * 
 * @author badboyh20
 *
 */
public class P10ResultDataVO {
	private String curr_total_page;
	private String curr_total_rec;
	private String total_page;
	private String total_rec;
	private List<Map<String, Object>> result_data;
	
	public P10ResultDataVO() {
		super();
	}
	
	public String getCurr_total_page() {
		return curr_total_page;
	}
	public void setCurr_total_page(String curr_total_page) {
		this.curr_total_page = curr_total_page;
	}
	public String getCurr_total_rec() {
		return curr_total_rec;
	}
	public void setCurr_total_rec(String curr_total_rec) {
		this.curr_total_rec = curr_total_rec;
	}
	public String getTotal_page() {
		return total_page;
	}
	public void setTotal_page(String total_page) {
		this.total_page = total_page;
	}
	public String getTotal_rec() {
		return total_rec;
	}
	public void setTotal_rec(String total_rec) {
		this.total_rec = total_rec;
	}
	public List<Map<String, Object>> getResult_data() {
		return result_data;
	}
	public void setResult_data(List<Map<String, Object>> result_data) {
		this.result_data = result_data;
	}
}
