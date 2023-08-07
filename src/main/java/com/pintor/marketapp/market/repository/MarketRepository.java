package com.pintor.marketapp.market.repository;

import com.pintor.marketapp.market.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market, Long> {
}
