package com.aston.componentsystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AircraftResponseDTO {
    private Integer id;
    private Integer serialNumber;
    private String regNumber;
    private String description;
    private String model;
    private boolean isOperating;
    private List<ComponentResponseDTO> components;
}
