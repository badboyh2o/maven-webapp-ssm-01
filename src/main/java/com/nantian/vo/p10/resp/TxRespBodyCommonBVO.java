package com.nantian.vo.p10.resp;

public class TxRespBodyCommonBVO {
	private String TOTAL_PAGE;
	private String TOTAL_REC;
	private String CURR_TOTAL_PAGE;
	private String CURR_TOTAL_REC;
	private String STS_TRACE_ID;
	
	public TxRespBodyCommonBVO() {
		super();
	}
	public String getTOTAL_PAGE() {
		return TOTAL_PAGE;
	}
	public void setTOTAL_PAGE(String tOTAL_PAGE) {
		TOTAL_PAGE = tOTAL_PAGE;
	}
	public String getTOTAL_REC() {
		return TOTAL_REC;
	}
	public void setTOTAL_REC(String tOTAL_REC) {
		TOTAL_REC = tOTAL_REC;
	}
	public String getCURR_TOTAL_PAGE() {
		return CURR_TOTAL_PAGE;
	}
	public void setCURR_TOTAL_PAGE(String cURR_TOTAL_PAGE) {
		CURR_TOTAL_PAGE = cURR_TOTAL_PAGE;
	}
	public String getCURR_TOTAL_REC() {
		return CURR_TOTAL_REC;
	}
	public void setCURR_TOTAL_REC(String cURR_TOTAL_REC) {
		CURR_TOTAL_REC = cURR_TOTAL_REC;
	}
	public String getSTS_TRACE_ID() {
		return STS_TRACE_ID;
	}
	public void setSTS_TRACE_ID(String sTS_TRACE_ID) {
		STS_TRACE_ID = sTS_TRACE_ID;
	}
	
}
