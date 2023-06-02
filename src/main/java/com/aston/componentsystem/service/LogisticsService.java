package com.aston.componentsystem.service;

import com.aston.componentsystem.dto.BalanceRequestDTO;
import com.aston.componentsystem.dto.ComponentRequestDTO;
import com.aston.componentsystem.repository.BalanceRepository;
import com.aston.componentsystem.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class LogisticsService {
    private final WarehouseRepository warehouseRepository;
    private final BalanceRepository balanceRepository;

    public void purchasingComponent(ComponentRequestDTO componentRequestDTO, BalanceRequestDTO balance) {
        int companyBalance = balance.getBalance().compareTo(componentRequestDTO.getPrice());
        if (companyBalance >= 0) {
            BigDecimal bigDecimal = balance.getBalance().subtract(componentRequestDTO.getPrice());
            balanceRepository.save(bigDecimal);
            warehouseRepository.save(componentRequestDTO);
        } else {
            System.out.println("Insufficient balance to make the purchase.");
        }
    }

}
