package com.nantian.vo.p10.resp;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("TX")
public class TxRespVO {

	@XStreamAlias("TX_HEADER")
	private TxRespHeadVO txRespHead;
	
	@XStreamAlias("TX_BODY")
	private TxRespBodyVO txRespBody;

	// C
	public TxRespVO() {
		super();
	}
	// getter/setter
	public TxRespHeadVO getTxRespHead() {
		return txRespHead;
	}
	public void setTxRespHead(TxRespHeadVO txRespHead) {
		this.txRespHead = txRespHead;
	}
	public TxRespBodyVO getTxRespBody() {
		return txRespBody;
	}
	public void setTxRespBody(TxRespBodyVO txRespBody) {
		this.txRespBody = txRespBody;
	}
}
