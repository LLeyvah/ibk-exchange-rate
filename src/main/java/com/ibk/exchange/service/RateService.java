package com.ibk.exchange.service;

import com.ibk.exchange.component.ExchangeRateAdapter;
import com.ibk.exchange.controllers.model.exchange.ExchangeRateRequest;
import com.ibk.exchange.controllers.model.exchange.ExchangeRateResponse;
import com.ibk.exchange.controllers.model.rate.Rate;
import com.ibk.exchange.controllers.model.rate.RateRequest;
import com.ibk.exchange.repository.RateRepository;
import com.ibk.exchange.repository.entity.RateEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RateService implements IRateService {
    private final RateRepository exchangeRateRepository;
    private final ExchangeRateAdapter exchangeRateAdapter;


    @Override
    public List<Rate> listAllExchangeRates() {
        return exchangeRateAdapter.toExchangeRate(exchangeRateRepository.findAll());
    }

    @Override
    public void updateRate(RateRequest rateRequest) {
        RateEntity rate = exchangeRateRepository
                .findByCurrency(rateRequest.getCurrency());
        rate.setRate(String.valueOf(rateRequest.getRate()));
        exchangeRateRepository.save(rate);
    }

    @Override
    public ExchangeRateResponse generateExchangeRate(ExchangeRateRequest exchangeRateRequest) {
        var exchangeRateResponse = new ExchangeRateResponse();
        RateEntity rateEntity = exchangeRateRepository.findByCurrency(exchangeRateRequest.getTargetCurrency());
        BigDecimal amountConvert = BigDecimal.valueOf(exchangeRateRequest.getAmount() * Double.parseDouble(rateEntity.getRate()))
                .setScale(2, RoundingMode.HALF_UP);
        exchangeRateResponse.setTargetAmount(amountConvert);
        return exchangeRateResponse;
    }
}
