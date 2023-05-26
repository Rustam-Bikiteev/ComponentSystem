package com.aston.componentsystem.repository;

import com.aston.componentsystem.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component, Integer> {
}
