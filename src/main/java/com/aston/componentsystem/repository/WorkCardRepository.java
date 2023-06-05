package com.aston.componentsystem.repository;

import com.aston.componentsystem.model.WorkCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkCardRepository extends JpaRepository<WorkCard,Integer> {
}
