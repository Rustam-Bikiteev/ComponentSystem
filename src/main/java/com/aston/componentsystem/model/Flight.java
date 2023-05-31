package com.aston.componentsystem.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer duration;
    @Column(name = "rate_per_hour")
    private float ratePerHour;
    @Column(name = "flight_date")
    private Date date;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "aircraft_id",nullable = false)
    private Aircraft aircraftId;

}
