package com.example.trade.mgmt;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.trade.service.TradeWatcher;

@Component
public class MasterScheduler {
	
	private final Logger log = LoggerFactory.getLogger(MasterScheduler.class.getName());
	
	@Autowired
	private TradeWatcher tradeWatcher;
	
	
	@PostConstruct
	public void init() {
		scheduleTradeWatcher();
	}
	
	//@Scheduled(fixedRateString = "10000")
	@Scheduled(cron = "0 0 0 * * ?") //run at 12 AM every day
	public void scheduleTradeWatcher() {
		log.debug("watcher started :: {}", LocalDateTime.now());
		tradeWatcher.doWatchTradeValidity();
		log.debug("watcher Ended :: {}", LocalDateTime.now());
	}

}
