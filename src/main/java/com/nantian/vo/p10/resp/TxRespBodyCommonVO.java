package com.nantian.vo.p10.resp;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class TxRespBodyCommonVO {
	@XStreamAlias("COMB")
	private TxRespBodyCommonBVO txRespBodyCommonBVO;

	public TxRespBodyCommonVO() {
		super();
	}

	public TxRespBodyCommonBVO getTxRespBodyCommonBVO() {
		return txRespBodyCommonBVO;
	}

	public void setTxRespBodyCommonBVO(TxRespBodyCommonBVO txRespBodyCommonBVO) {
		this.txRespBodyCommonBVO = txRespBodyCommonBVO;
	}
	
}
