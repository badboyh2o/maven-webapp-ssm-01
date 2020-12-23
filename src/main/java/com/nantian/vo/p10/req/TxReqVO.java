package com.nantian.vo.p10.req;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("TX")
public class TxReqVO {

	@XStreamAlias("TX_HEADER")
	private TxReqHeadVO txReqHead;
	
	@XStreamAlias("TX_BODY")
	private TxReqBodyVO txReqBody;

	// C
	public TxReqVO() {
		super();
	}
	// getter/setter

	public TxReqHeadVO getTxReqHead() {
		return txReqHead;
	}

	public void setTxReqHead(TxReqHeadVO txReqHead) {
		this.txReqHead = txReqHead;
	}

	public TxReqBodyVO getTxReqBody() {
		return txReqBody;
	}

	public void setTxReqBody(TxReqBodyVO txReqBody) {
		this.txReqBody = txReqBody;
	}


}
