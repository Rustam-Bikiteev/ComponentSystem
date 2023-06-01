package com.aston.componentsystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AircraftRequestDTO {
    private Integer serialNumber;
    private String regNumber;
    private String description;
    private String model;
    private boolean isOperating;
    private List<ComponentRequestDTO> components;
}
