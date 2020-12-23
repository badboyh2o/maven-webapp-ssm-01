package com.nantian.vo.p10.req;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class TxReqBodyCommonVO {
	@XStreamAlias("COM1")
	private TxReqBodyCommon1VO txReqBodyCommon1;

	public TxReqBodyCommonVO() {
		super();
	}

	public TxReqBodyCommon1VO getTxReqBodyCommon1() {
		return txReqBodyCommon1;
	}

	public void setTxReqBodyCommon1(TxReqBodyCommon1VO txReqBodyCommon1) {
		this.txReqBodyCommon1 = txReqBodyCommon1;
	}
	
	
}
