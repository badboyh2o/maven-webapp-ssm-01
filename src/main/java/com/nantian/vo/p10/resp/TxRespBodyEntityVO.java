package com.nantian.vo.p10.resp;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class TxRespBodyEntityVO {

	private String Trstr_InsID;
	private String Chnl_ID;
	private String IdCst_CrLine;
	private String Cst_Lgl_Nm;
	private String Crdt_TpCd;
	private String Crdt_No;
	private String Cr_Vrty_Cd_Dsc;
	
	@XStreamAlias("CGS_GJJ_GRP")
	private TxRespBodyEntityGjjVO txRespBodyEntityGjj;

	
	
	public TxRespBodyEntityVO() {
		super();
	}

	public String getTrstr_InsID() {
		return Trstr_InsID;
	}

	public void setTrstr_InsID(String trstr_InsID) {
		Trstr_InsID = trstr_InsID;
	}

	public String getChnl_ID() {
		return Chnl_ID;
	}

	public void setChnl_ID(String chnl_ID) {
		Chnl_ID = chnl_ID;
	}

	public String getIdCst_CrLine() {
		return IdCst_CrLine;
	}

	public void setIdCst_CrLine(String idCst_CrLine) {
		IdCst_CrLine = idCst_CrLine;
	}

	public String getCst_Lgl_Nm() {
		return Cst_Lgl_Nm;
	}

	public void setCst_Lgl_Nm(String cst_Lgl_Nm) {
		Cst_Lgl_Nm = cst_Lgl_Nm;
	}

	public String getCrdt_TpCd() {
		return Crdt_TpCd;
	}

	public void setCrdt_TpCd(String crdt_TpCd) {
		Crdt_TpCd = crdt_TpCd;
	}

	public String getCrdt_No() {
		return Crdt_No;
	}

	public void setCrdt_No(String crdt_No) {
		Crdt_No = crdt_No;
	}

	public TxRespBodyEntityGjjVO getTxRespBodyEntityGjj() {
		return txRespBodyEntityGjj;
	}

	public void setTxRespBodyEntityGjj(TxRespBodyEntityGjjVO txRespBodyEntityGjj) {
		this.txRespBodyEntityGjj = txRespBodyEntityGjj;
	}

	public String getCr_Vrty_Cd_Dsc() {
		return Cr_Vrty_Cd_Dsc;
	}

	public void setCr_Vrty_Cd_Dsc(String cr_Vrty_Cd_Dsc) {
		Cr_Vrty_Cd_Dsc = cr_Vrty_Cd_Dsc;
	}
}
