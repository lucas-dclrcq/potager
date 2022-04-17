package org.ldclrcq.infrastructure.out.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.ldclrcq.domain.SquareType;

import javax.persistence.*;
import java.util.List;

@Entity(name = "square")
public class SquareEntity extends PanacheEntity {
    @Column(name = "position_x")
    public Long positionX;

    @Column(name = "position_y")
    public Long positionY;

    @Column(name = "garden_id", insertable = false, updatable = false)
    public Long gardenId;

    @OneToMany(mappedBy = "square")
    public List<PlantationEntity> plantation;

    @Column(name = "type", columnDefinition = "VARCHAR(20)")
    @Enumerated(EnumType.STRING)
    public SquareType type;
}