package com.example.trade.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trade.model.Trade;
import com.example.trade.model.TradeDTO;
import com.example.trade.model.TradeId;
import com.example.trade.repo.TradeRepo;

@Service
public class TradeService {

	@Autowired
	private TradeRepo tradeRepo;

	public void saveTrade(TradeDTO tradeDTO) throws Exception {

		Long maxVersion = tradeRepo.findMaxVersion(tradeDTO.getTradeId());
		if (Objects.nonNull(maxVersion) && maxVersion > tradeDTO.getVersion()) {
			throw new Exception("Lower Version recieved");
		}
		LocalDateTime maturityDate = getMaturityDate(tradeDTO.getMaturityDate());
		LocalDateTime currDate = LocalDateTime.now();
		if (maturityDate.isBefore(currDate)) {
			throw new Exception("Invalid Maturity Date");
		}
		TradeId tradeId = new TradeId(tradeDTO.getTradeId(), tradeDTO.getVersion());
		Trade tradeEntity = tradeRepo.findById(tradeId).orElse(null);
		if (Objects.isNull(tradeEntity)) {
			tradeEntity = new Trade();
			tradeEntity.setId(tradeId);
		}
		tradeEntity.setBookId(tradeDTO.getBookId());
		tradeEntity.setCpId(tradeDTO.getCpId());
		tradeEntity.setMaturityDate(maturityDate);
		tradeEntity.setCreatedDate(currDate);
		tradeEntity.setExpired(Objects.nonNull(tradeDTO.getExpired()) ? tradeDTO.getExpired() : "N");
		tradeRepo.save(tradeEntity);

	}

	public LocalDateTime getMaturityDate(String dateStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime maturityDate = LocalDateTime.parse(dateStr, formatter);
		return maturityDate;
	}
}
