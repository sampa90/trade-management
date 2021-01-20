package com.example.trade.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.trade.PayloadUtil;
import com.example.trade.model.TradeDTO;
import com.example.trade.service.TradeService;
import com.fasterxml.jackson.core.JsonProcessingException;

@ExtendWith(MockitoExtension.class)
class TradeControllerTest {
	
	@InjectMocks
	private TradeController controller;
	
	@Mock
	private TradeService service;
	
	private PayloadUtil payloadUtil = new PayloadUtil();

	@Test
	void saveTradeTest_1() throws JsonProcessingException, Exception {
		
		doNothing().when(service).saveTrade(any(TradeDTO.class));
		ResponseEntity saveTrade = controller.saveTrade(payloadUtil.getTradeObj(PayloadUtil.TRADE_PAYLOAD_1));
		assertEquals(HttpStatus.OK, saveTrade.getStatusCode());
		
	}
	
	@Test
	void saveTradeTest_2() throws JsonProcessingException, Exception {
		doThrow(NullPointerException.class).when(service).saveTrade(any(TradeDTO.class));
		assertThrows(Exception.class, () -> controller.saveTrade(payloadUtil.getTradeObj(PayloadUtil.TRADE_PAYLOAD_1)));
		
	}

}
