package com.aston.componentsystem.service;

import com.aston.componentsystem.model.Aircraft;
import com.aston.componentsystem.model.Component;
import com.aston.componentsystem.repository.AircraftRepository;
import com.aston.componentsystem.repository.ComponentRepository;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ComponentService {

    private final ComponentRepository componentRepository;
    private final AircraftRepository aircraftRepository;

    public List<Component> getAllComponents() {
        return componentRepository.findAll();
    }

    public Component getComponentById(int id) {
        Optional<Component> componentOptional = componentRepository.findById(id);
        if (componentOptional.isEmpty()) {
            throw new NullPointerException();
        }
        return componentOptional.get();
    }

    public void saveComponent(@Validated Component component,  Integer id) {
        Aircraft aircraft = aircraftRepository.findById(id).get();
        aircraft.addingComponent(component);
        component.setAircraft(aircraft);
        componentRepository.save(component);
        log.info("Method name: saveComponent {Addition to specific Aircraft component} " + id + "Aircraft");
    }

    public void deleteComponent(int id) {
        Optional<Component> component = componentRepository.findById(id);
        if (component.isEmpty()) {
            throw new NullPointerException();
        }
        componentRepository.deleteById(id);
    }
}
