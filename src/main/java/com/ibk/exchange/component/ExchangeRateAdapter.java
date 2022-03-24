package com.ibk.exchange.component;

import com.ibk.exchange.controllers.model.rate.Rate;
import com.ibk.exchange.repository.entity.RateEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ExchangeRateAdapter {

    public List<Rate> toExchangeRate(List<RateEntity> exchangeRateEntities) {
        var exchangeRates = new ArrayList<Rate>();
        exchangeRateEntities.forEach(rateEntity -> {
            var exchangeRate = new Rate();
            exchangeRate.setCurrency(rateEntity.getCurrency());
            exchangeRate.setRate(Double.valueOf(rateEntity.getRate()));
            exchangeRate.setCodeCurrency(rateEntity.getCodeCurrency());
            exchangeRates.add(exchangeRate);
        });
        return exchangeRates;
    }
}
