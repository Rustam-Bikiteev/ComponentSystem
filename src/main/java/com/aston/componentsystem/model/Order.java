package com.aston.componentsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "component_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int component_quantity;
    @OneToMany
    @JoinColumn(name = "component_id")
    private List<Component> components;
}



