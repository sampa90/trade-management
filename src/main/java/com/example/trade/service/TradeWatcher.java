package com.example.trade.service;

import java.util.List;

import com.example.trade.model.Trade;

public interface TradeWatcher {
	
	public List<Trade> doWatchTradeValidity();

}
