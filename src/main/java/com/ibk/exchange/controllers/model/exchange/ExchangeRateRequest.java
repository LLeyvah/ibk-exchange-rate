package com.ibk.exchange.controllers.model.exchange;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateRequest {
    private Double amount;
    private String sourceCurrency;
    private String targetCurrency;
}
