package com.example.trade.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.trade.PayloadUtil;
import com.example.trade.repo.TradeRepo;
import com.fasterxml.jackson.core.JsonProcessingException;

@ExtendWith(MockitoExtension.class)
class TradeServiceTest {
	
	@InjectMocks
	private TradeService tradeService;
	
	@Mock
	private TradeRepo tradeRepo;
	
	private PayloadUtil payloadUtil = new PayloadUtil();

	@Test
	@DisplayName("Check the lower version of trade")
	void testSaveTrade() throws JsonProcessingException, Exception {
		
		when(tradeRepo.findMaxVersion(anyString())).thenReturn(2L);
		assertThrows(Exception.class, ()-> tradeService.saveTrade(payloadUtil.getTradeObj(PayloadUtil.TRADE_PAYLOAD_1)));
		
		
	}

	@Test
	void testGetMaturityDate() {
		LocalDateTime maturityDate = tradeService.getMaturityDate("17/01/2021 21:37:00");
		assertNotNull(maturityDate);
	}

}
