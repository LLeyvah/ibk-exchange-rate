package com.ibk.exchange.controllers;

import com.ibk.exchange.controllers.model.exchange.ExchangeRateRequest;
import com.ibk.exchange.controllers.model.exchange.ExchangeRateResponse;
import com.ibk.exchange.controllers.model.rate.Rate;
import com.ibk.exchange.controllers.model.rate.RateRequest;
import com.ibk.exchange.service.IRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ibk/v1")
public class ExchangeRateController {
    private final IRateService service;

    @GetMapping("/exchange/rates")
    public List<Rate> listAllRates() {
        return service.listAllExchangeRates();
    }

    @PostMapping("/exchange/rate")
    private void changeRate(@RequestBody RateRequest request) {
        service.updateRate(request);
    }

    @PostMapping("/exchange/rate/convert")
    private ExchangeRateResponse convertRate(@RequestBody ExchangeRateRequest request) {
        return service.generateExchangeRate(request);
    }
}
