package com.nantian.vo.p10.resp;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class TxRespBodyCommonVO {
	@XStreamAlias("COM1")
	private TxRespBodyCommon1VO txRespBodyCommon1;
	@XStreamAlias("COM7")
	private TxRespBodyCommon7VO txRespBodyCommon7;
	@XStreamAlias("COMA")
	private TxRespBodyCommonAVO txRespBodyCommonA;
	
	public TxRespBodyCommonVO() {
		super();
	}
	public TxRespBodyCommon1VO getTxRespBodyCommon1() {
		return txRespBodyCommon1;
	}
	public void setTxRespBodyCommon1(TxRespBodyCommon1VO txRespBodyCommon1) {
		this.txRespBodyCommon1 = txRespBodyCommon1;
	}
	public TxRespBodyCommonAVO getTxRespBodyCommonA() {
		return txRespBodyCommonA;
	}
	public void setTxRespBodyCommonA(TxRespBodyCommonAVO txRespBodyCommonA) {
		this.txRespBodyCommonA = txRespBodyCommonA;
	}
	public TxRespBodyCommon7VO getTxRespBodyCommon7() {
		return txRespBodyCommon7;
	}
	public void setTxRespBodyCommon7(TxRespBodyCommon7VO txRespBodyCommon7) {
		this.txRespBodyCommon7 = txRespBodyCommon7;
	}
	
}
