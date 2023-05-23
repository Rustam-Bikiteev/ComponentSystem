package com.aston.componentsystem.controller;

import com.aston.componentsystem.service.ComponentService;
import com.aston.componentsystem.model.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComponentController {

    public final ComponentService componentService;

    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @GetMapping("/components")
    public List<Component> getAllComponents() {
        return componentService.getAllComponents();
    }

    @GetMapping("/components/{id}")
    public Component getComponentById(@PathVariable int id) {
        return componentService.getComponentById(id);
    }

    @PostMapping("/component")
    public void saveComponent(@RequestBody Component component) {
    componentService.saveComponent(component);
    }

    @DeleteMapping("/component/{id}")
    public void deleteComponent(@PathVariable int id){
        Component component = componentService.getComponentById(id);
        if (component != null) {
            componentService.deleteComponent(id);
        }
    }

}
