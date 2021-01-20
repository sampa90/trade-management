package com.example.trade.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TradeId implements Serializable{
	
	@Column(name = "trade_id", nullable = false)
	private String tradeId;
	
	@Column(name = "version", nullable = false)
	private Long version;

	public TradeId() {
		super();
	}

	public TradeId(String tradeId, Long version) {
		super();
		this.tradeId = tradeId;
		this.version = version;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	
	
}
