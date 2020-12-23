package com.nantian.vo.p10.req;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class TxReqBodyVO {
	@XStreamAlias("COMMON")
	private TxReqBodyCommonVO txReqBodyCommon;
	@XStreamAlias("ENTITY")
	private TxReqBodyEntityVO txReqBodyEntity;
	
	public TxReqBodyVO() {
		super();
	}

	public TxReqBodyEntityVO getTxReqBodyEntity() {
		return txReqBodyEntity;
	}

	public void setTxReqBodyEntity(TxReqBodyEntityVO txReqBodyEntity) {
		this.txReqBodyEntity = txReqBodyEntity;
	}

	public TxReqBodyCommonVO getTxReqBodyCommon() {
		return txReqBodyCommon;
	}

	public void setTxReqBodyCommon(TxReqBodyCommonVO txReqBodyCommon) {
		this.txReqBodyCommon = txReqBodyCommon;
	}
	
}
