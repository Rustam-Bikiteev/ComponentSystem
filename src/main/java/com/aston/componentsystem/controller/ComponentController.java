package com.aston.componentsystem.controller;

import com.aston.componentsystem.dto.ComponentRequestDTO;
import com.aston.componentsystem.dto.ComponentResponseDTO;
import com.aston.componentsystem.service.ComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ComponentController {

    private final ComponentService componentService;

    @GetMapping("/components")
    public List<ComponentResponseDTO> getAllComponents() {
        return componentService.getAllComponents();
    }

    @GetMapping("/component/{id}")
    public ComponentResponseDTO getComponentById(@PathVariable int id) {
        return componentService.getComponentById(id);
    }

    @PostMapping("/component")
    public void saveComponent(@RequestBody ComponentRequestDTO componentRequestDTO) {
        componentService.saveComponent(componentRequestDTO);
    }

    @DeleteMapping("/component/{id}")
    public void deleteComponent(@PathVariable int id) {
        componentService.deleteComponent(id);
    }
}
