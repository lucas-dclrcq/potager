package org.ldclrcq.infrastructure.out.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.ldclrcq.domain.PlantationType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "plantation")
public class PlantationEntity extends PanacheEntity {
    @ManyToOne
    @JoinColumn(name = "square_id")
    public SquareEntity square;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    public PlantEntity plant;

    @Column(name = "planned_date", columnDefinition = "DATE")
    public LocalDate plannedDate;

    @Column(name = "plantation_date", columnDefinition = "DATE")
    public LocalDate plantationDate;

    @Column(name = "harvest_date", columnDefinition = "DATE")
    public LocalDate harvestDate;

    @Column(name = "type", columnDefinition = "VARCHAR(20)")
    @Enumerated(value = EnumType.STRING)
    public PlantationType type;
}
