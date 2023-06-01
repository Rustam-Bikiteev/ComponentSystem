package com.aston.componentsystem.controller;

import com.aston.componentsystem.model.Aircraft;
import com.aston.componentsystem.service.AircraftService;
import com.aston.componentsystem.service.ComponentService;
import com.aston.componentsystem.model.Component;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/component")
public class ComponentController {

    public final ComponentService componentService;
    private final AircraftService aircraftService;

    @GetMapping("/components")
    public List<Component> getAllComponents() {
        return componentService.getAllComponents();
    }

    @GetMapping("/component/{id}")
    public Component getComponentById(@PathVariable int id) {
        Aircraft aircraft = aircraftService.getAircraftById(id);
        return componentService.getComponentById(id);
    }

    @PostMapping("/component/{idAircraft}")
    public void saveComponent(@RequestBody Component component,
                              @PathVariable(value = "idAircraft")
                              @Parameter(description = "Присоединение component к Aircraft") Integer idAircraft) {
        componentService.saveComponent(component,idAircraft);
    }

    @DeleteMapping("/component/{id}")
    public void deleteComponent(@PathVariable int id) {
        componentService.deleteComponent(id);
    }

}
