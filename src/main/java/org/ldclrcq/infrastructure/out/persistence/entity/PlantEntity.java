package org.ldclrcq.infrastructure.out.persistence.entity;

import com.vladmihalcea.hibernate.type.interval.PostgreSQLIntervalType;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.TypeDef;
import org.ldclrcq.domain.PlantationPattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.Duration;

@Entity(name = "plant")
@TypeDef(
        typeClass = PostgreSQLIntervalType.class,
        defaultForType = Duration.class
)
public class PlantEntity extends PanacheEntity {
    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    public String name;

    @Column(name = "plantation_pattern", columnDefinition = "VARCHAR(20)")
    @Enumerated(EnumType.STRING)
    public PlantationPattern plantationPattern;

    @Column(name = "time_to_harvest", columnDefinition = "interval")
    public Duration timeToHarvest;
}
