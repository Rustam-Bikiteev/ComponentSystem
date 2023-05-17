package com.aston.componentsystem.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int quantity;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "warehouse")
    private List<Component> componentId;

    public Warehouse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Component> getComponentId() {
        return componentId;
    }

    public void setComponentId(List<Component> componentId) {
        this.componentId = componentId;
    }
}
