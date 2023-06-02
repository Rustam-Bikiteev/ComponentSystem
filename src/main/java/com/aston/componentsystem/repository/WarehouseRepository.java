package com.aston.componentsystem.repository;

import com.aston.componentsystem.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
}