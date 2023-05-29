package com.aston.componentsystem.controller;

import com.aston.componentsystem.service.ComponentService;
import com.aston.componentsystem.model.Component;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ComponentController {

    public final ComponentService componentService;

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
    public void deleteComponent(@PathVariable int id) {
        componentService.deleteComponent(id);
    }

}
