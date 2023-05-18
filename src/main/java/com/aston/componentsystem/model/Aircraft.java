package com.aston.componentsystem.model;
import jakarta.persistence.*;


import java.util.Set;

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
    @OneToMany(mappedBy = "aircraftId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Component> components;
    @OneToOne(mappedBy = "aircraftId")
    private WorkCard workCard;

    public Aircraft() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isOperating() {
        return isOperating;
    }

    public void setOperating(boolean operating) {
        isOperating = operating;
    }

    public Set<Component> getComponents() {
        return components;
    }

    public void setComponents(Set<Component> components) {
        this.components = components;
    }

    public WorkCard getWorkCard() {
        return workCard;
    }

    public void setWorkCard(WorkCard workCard) {
        this.workCard = workCard;
    }
}
