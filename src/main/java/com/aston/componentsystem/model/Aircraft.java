package com.aston.componentsystem.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "serial_number",nullable = false)
    private int serialNumber;
    @Column(name = "reg_number",nullable = false)
    private String regNumber;
    private String description;
    private String model;
    private boolean isOperating;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aircraftId")
    private List<Component> components;
    @OneToOne(mappedBy = "aircraftId")
    private WorkCard workCards;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aircraftId")
    private List<Flight> flights;

}
