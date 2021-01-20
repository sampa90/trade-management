package com.example.trade.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Trade")
public class Trade implements Serializable{

	@EmbeddedId
	@AttributeOverrides({@AttributeOverride(name ="tradeId", column = @Column(name="trade_id")), 
		@AttributeOverride(name ="version", column = @Column(name="version"))})
	private TradeId id;
	
	@Column(name = "cp_id")
	private String cpId;
	
	@Column(name = "book_id")
	private String bookId;
	
	@Column(name = "maturity_date")
	private LocalDateTime maturityDate;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@Column(name = "expired")
	private String expired;

	public Trade() {
		super();
	}

	public Trade(TradeId id, String cpId, String bookId, LocalDateTime maturityDate, LocalDateTime createdDate,
			String expired) {
		super();
		this.id = id;
		this.cpId = cpId;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.expired = expired;
	}

	public TradeId getId() {
		return id;
	}

	public void setId(TradeId id) {
		this.id = id;
	}

	public String getCpId() {
		return cpId;
	}

	public void setCpId(String cpId) {
		this.cpId = cpId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public LocalDateTime getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(LocalDateTime maturityDate) {
		this.maturityDate = maturityDate;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getExpired() {
		return expired;
	}

	public void setExpired(String expired) {
		this.expired = expired;
	}
	
	public Trade update(Trade t, String expiredFlag) {
		t.setExpired("Y");
		return t;
	}
	
}
