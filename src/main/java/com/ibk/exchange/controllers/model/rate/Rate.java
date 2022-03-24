package com.ibk.exchange.controllers.model.rate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rate {
    private String currency;
    private Double rate;
    private String codeCurrency;

}
