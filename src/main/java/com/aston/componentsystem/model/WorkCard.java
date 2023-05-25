package com.aston.componentsystem.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class WorkCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "planned_date")
    private Date plannedDate;
    @Column(name = "replacement_date",nullable = false)
    private Date replacementDate;
    private boolean status;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "aircraft_id",nullable = false)
    private Aircraft aircraftId;

   @OneToMany(fetch = FetchType.EAGER, mappedBy = "workCard")
    private List<Component> components;

}
