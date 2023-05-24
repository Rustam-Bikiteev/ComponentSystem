package com.aston.componentsystem.service;

import com.aston.componentsystem.model.Component;
import com.aston.componentsystem.repository.ComponentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComponentService {

    public final ComponentRepository componentRepository;


    public List<Component> getAllComponents() {
        return componentRepository.findAll();
    }

    public Optional<Component> getComponentById(int id) {
        return componentRepository.findById(id);
    }

    public void saveComponent(Component component){
        componentRepository.save(component);
    }

    public void deleteComponent(int id){
       componentRepository.deleteById(id);
    }
}
