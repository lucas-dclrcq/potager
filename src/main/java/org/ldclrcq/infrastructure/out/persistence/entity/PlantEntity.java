package org.ldclrcq.infrastructure.out.persistence.entity;

import com.vladmihalcea.hibernate.type.interval.PostgreSQLIntervalType;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.*;
import org.ldclrcq.domain.PlantationPattern;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.Duration;
import java.util.Set;

@Entity(name = "plant")
@TypeDef(
        typeClass = PostgreSQLIntervalType.class,
        defaultForType = Duration.class
)
public class PlantEntity extends PanacheEntity {
    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    public String name;

    @Column(name = "latin_name", columnDefinition = "TEXT")
    public String latinName;

    @Column(name = "min_height_in_cm", columnDefinition = "INTEGER")
    public Integer minHeightInCm;

    @Column(name = "max_height_in_cm", columnDefinition = "INTEGER")
    public Integer maxHeightInCm;

    @Column(name = "plantation_pattern", columnDefinition = "VARCHAR(20)")
    @Enumerated(EnumType.STRING)
    public PlantationPattern plantationPattern;

    @Column(name = "time_to_harvest", columnDefinition = "interval")
    public Duration timeToHarvest;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "plant_association",
            joinColumns = {@JoinColumn(name = "first_plant_id")},
            inverseJoinColumns = {@JoinColumn(name = "second_plant_id")})
    @WhereJoinTable(clause = "type='POSITIVE'")
    public Set<PlantEntity> positiveAssociations;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "plant_association",
            joinColumns = {@JoinColumn(name = "first_plant_id")},
            inverseJoinColumns = {@JoinColumn(name = "second_plant_id")})
    @WhereJoinTable(clause = "type='NEGATIVE'")
    public Set<PlantEntity> negativeAssociations;
}
