package com.aston.componentsystem.repository;

import com.aston.componentsystem.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface BalanceRepository extends JpaRepository<Balance, Integer> {
    void save(BigDecimal bigDecimal);

}