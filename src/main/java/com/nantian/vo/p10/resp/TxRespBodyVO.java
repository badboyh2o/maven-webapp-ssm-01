package com.nantian.vo.p10.resp;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class TxRespBodyVO {
	
	@XStreamAlias("COMMON")
	private TxRespBodyCommonVO txRespBodyCommon;
	@XStreamAlias("ENTITY")
	private TxRespBodyEntityVO txRespBodyEntity;
	
	public TxRespBodyVO() {
		super();
	}
	public TxRespBodyCommonVO getTxRespBodyCommon() {
		return txRespBodyCommon;
	}
	public void setTxRespBodyCommon(TxRespBodyCommonVO txRespBodyCommon) {
		this.txRespBodyCommon = txRespBodyCommon;
	}
	public TxRespBodyEntityVO getTxRespBodyEntity() {
		return txRespBodyEntity;
	}
	public void setTxRespBodyEntity(TxRespBodyEntityVO txRespBodyEntity) {
		this.txRespBodyEntity = txRespBodyEntity;
	}
	
}
