package com.pintor.marketapp.market.controller;

import com.pintor.marketapp.market.service.MarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/market")
@RequiredArgsConstructor
@Controller
public class MarketController {

    private final MarketService marketService;
}
