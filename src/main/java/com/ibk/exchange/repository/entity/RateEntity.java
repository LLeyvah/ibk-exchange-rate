package com.ibk.exchange.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "exchange_rate")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String exchangeRateId;
    @Column(name = "currency")
    private String currency;
    @Column(name = "rate")
    private String rate;
    @Column(name = "active_rate")
    private String active;
    @Column(name = "code_currency")
    private String codeCurrency;
}
