package com.aston.componentsystem.dto;

import lombok.Data;

import java.util.Date;

@Data
public class WorkCardResponseDTO {
    private Integer id;
    private Date plannedDate;
    private Date replacementDate;
    private boolean done;
    private Integer aircraftId;
    private Integer componentId;
}

