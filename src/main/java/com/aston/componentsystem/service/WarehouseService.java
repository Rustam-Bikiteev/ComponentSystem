package com.aston.componentsystem.service;

import com.aston.componentsystem.model.Warehouse;
import com.aston.componentsystem.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;
    public WarehouseService(WarehouseRepository warehouseRepository){this.warehouseRepository=warehouseRepository;}
    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Warehouse getWarehouseById(int id) {
        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(id);
        if (!warehouseOptional.isPresent()) {
            throw new NullPointerException();
        }
        return warehouseOptional.get();
    }

    public void saveWarehouse(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }

    public void deleteWarehouse(int id) {
        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(id);
        if (!warehouseOptional.isPresent()) {
            throw new NullPointerException();
        }
        warehouseRepository.deleteById(id);
    }
}
