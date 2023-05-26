package com.aston.componentsystem.repository;

import com.aston.componentsystem.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {
}
