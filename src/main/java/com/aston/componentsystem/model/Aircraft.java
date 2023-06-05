package com.aston.componentsystem.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "serial_number", nullable = false)
    private Integer serialNumber;
    @Column(name = "reg_number", nullable = false)
    private String regNumber;
    private String description;
    private String model;
    private boolean isOperating;

    public Aircraft(Integer serialNumber, String regNumber, String description, String model, boolean isOperating) {
        this.serialNumber = serialNumber;
        this.regNumber = regNumber;
        this.description = description;
        this.model = model;
        this.isOperating = isOperating;
    }

    public Aircraft() {
    }


    @OneToMany(mappedBy = "aircraft", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Component> components;

    public void addingComponent(Component component) {
        if (this.components == null) {
            this.components = new ArrayList<>();
            this.components.add(component);
        }
    }
}
