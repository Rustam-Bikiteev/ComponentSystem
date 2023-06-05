package com.aston.componentsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class WorkCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "planned_date")
    private Date plannedDate;
    @Column(name = "replacement_date", nullable = false)
    private Date replacementDate;
    @Column(name = "is_done")
    private boolean isDone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "aircraft_id", referencedColumnName = "id")
    private Aircraft aircraft;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "component_id", referencedColumnName = "id")
    private Component component;

    public WorkCard(Integer id, Date plannedDate, Date replacementDate, boolean isDone) {
        this.id = id;
        this.plannedDate = plannedDate;
        this.replacementDate = replacementDate;
        this.isDone = isDone;
    }

    public WorkCard() {
    }

    @Override
    public String toString() {
        return "WorkCard{" +
            "id=" + id +
            ", plannedDate=" + plannedDate +
            ", replacementDate=" + replacementDate +
            ", isDone=" + isDone +
            ", aircraft=" + aircraft +
            ", component=" + component +
            '}';
    }
}
