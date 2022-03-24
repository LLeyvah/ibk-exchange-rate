package com.ibk.exchange.repository;

import com.ibk.exchange.repository.entity.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<RateEntity, Long> {

    RateEntity findByCurrency(String currency);

}

