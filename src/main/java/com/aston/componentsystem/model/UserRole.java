package com.aston.componentsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "roles")
public class UserRole {

    @Column(name = "is_removed", nullable = false)
    boolean isRemoved = Boolean.FALSE;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(length = 60, nullable = false)
    private String name;

    @Column(length = 60, nullable = false)
    private String role;
}
