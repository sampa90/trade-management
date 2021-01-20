package com.example.trade.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.trade.model.Trade;
import com.example.trade.model.TradeId;

@Repository
public interface TradeRepo extends JpaRepository<Trade, TradeId>{
	
	@Query(value = "SELECT max(t.id.version) FROM Trade t where t.id.tradeId = :tradeId")
	public Long findMaxVersion(String tradeId);
	
	public List<Trade> findByExpired(String flag);
	
}
