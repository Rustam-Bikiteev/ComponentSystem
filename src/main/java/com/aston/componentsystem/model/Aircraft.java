package com.aston.componentsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
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

    @OneToMany
    private List<Component> components;
    public void addingComponent(Component component) {
        if (this.components == null) {
            this.components = new ArrayList<>();
            this.components.add(component);
            }
    }
}
