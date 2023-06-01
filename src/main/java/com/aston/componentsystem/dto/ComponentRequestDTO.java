package com.aston.componentsystem.dto;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class ComponentRequestDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private boolean installed;
    private Integer lifeTime;
    private Date manufactureDate;
}
