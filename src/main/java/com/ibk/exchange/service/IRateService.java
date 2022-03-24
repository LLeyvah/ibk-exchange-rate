package com.ibk.exchange.service;

import com.ibk.exchange.controllers.model.exchange.ExchangeRateRequest;
import com.ibk.exchange.controllers.model.exchange.ExchangeRateResponse;
import com.ibk.exchange.controllers.model.rate.Rate;
import com.ibk.exchange.controllers.model.rate.RateRequest;

import java.util.List;

public interface IRateService {

    List<Rate> listAllExchangeRates();

     void updateRate(RateRequest rateRequest);

     ExchangeRateResponse generateExchangeRate(ExchangeRateRequest exchangeRateRequest);

}
