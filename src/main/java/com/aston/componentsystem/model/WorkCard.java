package com.aston.componentsystem.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class WorkCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "planned_date")
    private Date plannedDate;
    @Column(name = "replacement_date",nullable = false)
    private Date replacementDate;
    private boolean status;
    @Column(name = "aircraft_id",nullable = false)
    private Aircraft aircraftId;
    @Column(name = "component_id",nullable = false)
    private Component componentId;

    public WorkCard() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(Date plannedDate) {
        this.plannedDate = plannedDate;
    }

    public Date getReplacementDate() {
        return replacementDate;
    }

    public void setReplacementDate(Date replacementDate) {
        this.replacementDate = replacementDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Aircraft getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(Aircraft aircraftId) {
        this.aircraftId = aircraftId;
    }

    public Component getComponentId() {
        return componentId;
    }

    public void setComponentId(Component componentId) {
        this.componentId = componentId;
    }
}
