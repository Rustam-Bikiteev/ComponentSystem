package com.aston.componentsystem.service;

import com.aston.componentsystem.model.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComponentService {
    public List<Component> getAllComponents() {
        Component component = new Component();
        List<Component> components = new ArrayList<>();
        components.add(component);
        return components;
    }

    public Component getComponentById(int id) {
        return new Component();
    }

    public void saveComponent(Component component){
        System.out.println("Component has been created");
    }

    public void deleteComponent(int id){
        System.out.println("Component has been deleted");
    }
}
