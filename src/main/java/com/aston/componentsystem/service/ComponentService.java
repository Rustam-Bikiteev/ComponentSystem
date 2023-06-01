package com.aston.componentsystem.service;

import com.aston.componentsystem.dto.ComponentRequestDTO;
import com.aston.componentsystem.dto.ComponentResponseDTO;
import com.aston.componentsystem.model.Component;
import com.aston.componentsystem.repository.ComponentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComponentService {

    private final ComponentRepository componentRepository;
    private final ModelMapper modelMapper;



    public List<ComponentResponseDTO> getAllComponents() {
        List<Component> componentList = componentRepository.findAll();
        return componentList.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public ComponentResponseDTO getComponentById(int id) {
        Optional<Component> componentOptional = componentRepository.findById(id);
        if (!componentOptional.isPresent()) {
            throw new NullPointerException();
        }
        return convertToResponseDTO(componentOptional.get());
    }

    public void saveComponent(ComponentRequestDTO componentRequestDTO) {
        Component component = convertToEntity(componentRequestDTO);
        componentRepository.save(component);
    }

    public void deleteComponent(int id) {
        Optional<Component> component = componentRepository.findById(id);
        if (!component.isPresent()) {
            throw new NullPointerException();
        }
        componentRepository.deleteById(id);
    }

    private ComponentResponseDTO convertToResponseDTO(Component component) {
        return modelMapper.map(component, ComponentResponseDTO.class);
    }

    private Component convertToEntity(ComponentRequestDTO componentRequestDTO) {
        return modelMapper.map(componentRequestDTO, Component.class);
    }
}
