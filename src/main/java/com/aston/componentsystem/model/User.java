package com.aston.componentsystem.model;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {
    private int id;
    private String name;
    private String role;
    private String email;
}
