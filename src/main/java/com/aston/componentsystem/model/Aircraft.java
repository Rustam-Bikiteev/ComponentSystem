package com.aston.componentsystem.model;
import jakarta.persistence.*;
import java.util.List;

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
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "aircraftId")
    private List<Component> components;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "aircraftId")
    private List<WorkCard> workCards;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "aircraftId")
    private List<Flight> flights;

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

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public List<WorkCard> getWorkCards() {
        return workCards;
    }

    public void setWorkCards(List<WorkCard> workCards) {
        this.workCards = workCards;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
