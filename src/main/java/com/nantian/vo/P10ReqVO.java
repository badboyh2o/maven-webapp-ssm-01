package com.nantian.vo;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.nantian.util.RandomIdUtil;

/**
 * P10数据 请求VO
 * @author badboyh20
 *
 */
public class P10ReqVO {
	// 非接口字段
	private Date reqTime = new Date(); // 请求时间
	private String evtTraceId = RandomIdUtil.createEvtTranceId(new Date()); // 全局事件跟踪号，25位数字
	
	// 接口字段
	private String appid;
	private String itf_no;
	@NotNull
	@Valid
	private P10ReqParamVO req_params;
	private String req_tms;
	public P10ReqVO() {
		super();
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getItf_no() {
		return itf_no;
	}
	public void setItf_no(String itf_no) {
		this.itf_no = itf_no;
	}
	public P10ReqParamVO getReq_params() {
		return req_params;
	}
	public void setReq_params(P10ReqParamVO req_params) {
		this.req_params = req_params;
	}
	public String getReq_tms() {
		return req_tms;
	}
	public void setReq_tms(String req_tms) {
		this.req_tms = req_tms;
	}
	public Date getReqTime() {
		return reqTime;
	}
	public void setReqTime(Date reqTime) {
		this.reqTime = reqTime;
	}
	public String getEvtTraceId() {
		return evtTraceId;
	}
	public void setEvtTraceId(String evtTraceId) {
		this.evtTraceId = evtTraceId;
	}
	
}
