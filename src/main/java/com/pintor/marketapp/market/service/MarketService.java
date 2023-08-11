package com.pintor.marketapp.market.service;

import com.pintor.marketapp.market.repository.MarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MarketService {
    private final MarketRepository marketRepository;
}
