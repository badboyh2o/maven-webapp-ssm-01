package com.nantian.vo.p10.resp;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class TxRespBodyEntityVO {
	private String Ret_Col_Set_Inf;
	private String Clmn_Opt_Dsc;
	
	@XStreamAlias("ENQR_RST_GRP")
	private List<TxEnqrRstVO> ENQR_RST_GRP;

	public String getRet_Col_Set_Inf() {
		return Ret_Col_Set_Inf;
	}
	public void setRet_Col_Set_Inf(String ret_Col_Set_Inf) {
		Ret_Col_Set_Inf = ret_Col_Set_Inf;
	}
	public String getClmn_Opt_Dsc() {
		return Clmn_Opt_Dsc;
	}
	public void setClmn_Opt_Dsc(String clmn_Opt_Dsc) {
		Clmn_Opt_Dsc = clmn_Opt_Dsc;
	}
	public List<TxEnqrRstVO> getENQR_RST_GRP() {
		return ENQR_RST_GRP;
	}
	public void setENQR_RST_GRP(List<TxEnqrRstVO> eNQR_RST_GRP) {
		ENQR_RST_GRP = eNQR_RST_GRP;
	}
}
