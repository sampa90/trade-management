package com.example.trade.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trade.model.Trade;
import com.example.trade.repo.TradeRepo;

@Service
public class TradeWatcherImpl implements TradeWatcher {
	
	private final Logger log = LoggerFactory.getLogger(TradeWatcherImpl.class.getName());
	
	@Autowired
	private TradeRepo tradeRepo;

	@Override
	public List<Trade> doWatchTradeValidity() {
		
		//Get all trade details where the EXPIRED flag is N
		List<Trade> listTrades = tradeRepo.findByExpired("N");
		log.debug("listTrades :: {}", listTrades);
		
		List<Trade> expiredList = listTrades.stream().filter(t -> t.getMaturityDate().isBefore(LocalDateTime.now()))
				.map(t -> t.update(t, "Y"))
				.collect(Collectors.toList());
		
		log.debug("expiredList :: {}", expiredList);
		if(!expiredList.isEmpty()) {
			return tradeRepo.saveAll(expiredList);
		} else {
			return null;
		}
	}

}
