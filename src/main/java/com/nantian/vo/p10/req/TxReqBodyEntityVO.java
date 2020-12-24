package com.nantian.vo.p10.req;

public class TxReqBodyEntityVO {
	private String Cmpt_ID;
	private String Svc_ID;
	private String Bsn_Parm_Fld_Nm;
	private String Enqr_Cnd_Cntnt;
	
	public TxReqBodyEntityVO() {
		super();
	}
	public String getCmpt_ID() {
		return Cmpt_ID;
	}
	public void setCmpt_ID(String cmpt_ID) {
		Cmpt_ID = cmpt_ID;
	}
	public String getSvc_ID() {
		return Svc_ID;
	}
	public void setSvc_ID(String svc_ID) {
		Svc_ID = svc_ID;
	}
	public String getBsn_Parm_Fld_Nm() {
		return Bsn_Parm_Fld_Nm;
	}
	public void setBsn_Parm_Fld_Nm(String bsn_Parm_Fld_Nm) {
		Bsn_Parm_Fld_Nm = bsn_Parm_Fld_Nm;
	}
	public String getEnqr_Cnd_Cntnt() {
		return Enqr_Cnd_Cntnt;
	}
	public void setEnqr_Cnd_Cntnt(String enqr_Cnd_Cntnt) {
		Enqr_Cnd_Cntnt = enqr_Cnd_Cntnt;
	}

}
