package com.aston.componentsystem.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "is_installed")
    private boolean isInstalled;

    @Column(name = "life_time")
    private Integer lifeTime;

    @Column(name = "manufacture_date")
    private Date manufactureDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "aircraft_id", referencedColumnName = "id")
    private Aircraft aircraft;
}
