package com.aston.componentsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@Entity
@Table(name = "roles")
public class UserRole extends AbstractEntity{

    @Column(length = 60, nullable = false)
    private String name;
}