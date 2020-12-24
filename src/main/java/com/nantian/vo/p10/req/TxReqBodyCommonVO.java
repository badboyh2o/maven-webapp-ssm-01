package com.nantian.vo.p10.req;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class TxReqBodyCommonVO {
	@XStreamAlias("COM1")
	private TxReqBodyCommon1VO txReqBodyCommon1;
	@XStreamAlias("COM4")
	private TxReqBodyCommon4VO txReqBodyCommon4;
	@XStreamAlias("COM7")
	private TxReqBodyCommon7VO txReqBodyCommon7;
	public TxReqBodyCommonVO() {
		super();
	}
	public TxReqBodyCommon1VO getTxReqBodyCommon1() {
		return txReqBodyCommon1;
	}
	public void setTxReqBodyCommon1(TxReqBodyCommon1VO txReqBodyCommon1) {
		this.txReqBodyCommon1 = txReqBodyCommon1;
	}
	public TxReqBodyCommon4VO getTxReqBodyCommon4() {
		return txReqBodyCommon4;
	}
	public void setTxReqBodyCommon4(TxReqBodyCommon4VO txReqBodyCommon4) {
		this.txReqBodyCommon4 = txReqBodyCommon4;
	}
	public TxReqBodyCommon7VO getTxReqBodyCommon7() {
		return txReqBodyCommon7;
	}
	public void setTxReqBodyCommon7(TxReqBodyCommon7VO txReqBodyCommon7) {
		this.txReqBodyCommon7 = txReqBodyCommon7;
	}
}
