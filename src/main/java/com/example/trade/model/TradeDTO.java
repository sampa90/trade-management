package com.example.trade.model;

import java.time.LocalDateTime;
import java.util.Date;

/*import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString*/
public class TradeDTO {

	private String tradeId; 
	private Long version; 
	private String cpId;
	private String bookId;
	private String maturityDate;
	private LocalDateTime createdDate;
	private String expired;
	
	
	
	
	public TradeDTO() {
		super();
	}
	public TradeDTO(String tradeId, Long version, String cpId, String bookId, String maturityDate,
			LocalDateTime createdDate, String expired) {
		super();
		this.tradeId = tradeId;
		this.version = version;
		this.cpId = cpId;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.expired = expired;
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
	public String getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(String maturityDate) {
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
	
	
}
