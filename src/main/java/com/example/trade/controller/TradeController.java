package com.example.trade.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.trade.model.TradeDTO;
import com.example.trade.service.TradeService;

@RestController
public class TradeController {
	
	private final Logger log = LoggerFactory.getLogger(TradeController.class.getName());

	@Autowired
	private TradeService service;
	
	@PostMapping("/trade")
	public ResponseEntity saveTrade(@RequestBody TradeDTO tradeDTO) throws Exception{
		log.debug("Inside save trade...........");
		try {
			service.saveTrade(tradeDTO);
		} catch (Exception e) {
			log.error("Exception :: ",e);
			throw e;
		}
		return ResponseEntity.ok().build();
	}
}
