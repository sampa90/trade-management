package com.example.trade;

import com.example.trade.model.TradeDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PayloadUtil {
	
	public static final String TRADE_PAYLOAD_1 = "{\"tradeId\":\"T2\",\"version\":\"1\",\"cpId\":\"CP-2\",\"bookId\":\"B2\",\"maturityDate\":\"17/01/2021 21:37:00\"}";
	
	public TradeDTO getTradeObj(String json) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(json, TradeDTO.class);
		} catch (JsonProcessingException e) {
			throw e;
		}
	}

}
