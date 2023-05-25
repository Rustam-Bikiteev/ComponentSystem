package com.aston.componentsystem.service;

import com.aston.componentsystem.model.Component;
import com.aston.componentsystem.repository.ComponentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComponentService {
    private final ComponentRepository componentRepository;

    public ComponentService(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    public List<Component> getAllComponents() {
        return componentRepository.findAll();
    }

    public Component getComponentById(int id) {
        Optional<Component> componentOptional = componentRepository.findById(id);
        if (!componentOptional.isPresent()) {
            throw new NullPointerException();
        }
        return componentOptional.get();
    }

    public void saveComponent(Component component) {
        Component creatingComponent = new Component();
        creatingComponent.setName(component.getName());
        creatingComponent.setDescription(component.getDescription());
        creatingComponent.setPrice(component.getPrice());
        creatingComponent.setStatus(component.isStatus());
        creatingComponent.setLifeTime(component.getLifeTime());
        creatingComponent.setManufactureDate(component.getManufactureDate());
        creatingComponent.setAircraftId(component.getAircraftId());
        creatingComponent.setWorkCard(component.getWorkCard());
        creatingComponent.setWarehouse(component.getWarehouse());
    }

    public void deleteComponent(int id) {
        Optional<Component> component = componentRepository.findById(id);
        if (!component.isPresent()) {
            throw new NullPointerException();
        }
        componentRepository.deleteById(id);
    }
}
