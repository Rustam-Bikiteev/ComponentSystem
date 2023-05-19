package com.aston.componentsystem.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private BigDecimal balance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "balances")
    private List<Flight> flights;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "balances")
    private List<Component> components;

}
