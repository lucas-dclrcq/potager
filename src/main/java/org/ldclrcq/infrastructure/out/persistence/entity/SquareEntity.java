package org.ldclrcq.infrastructure.out.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "square")
public class SquareEntity extends PanacheEntity {
    @Column(name = "position_x")
    public Long positionX;

    @Column(name = "position_y")
    public Long positionY;

    @OneToMany(mappedBy = "square")
    public List<PlantationEntity> plantation;

    @ManyToOne
    @JoinColumn(name = "garden_id")
    public GardenEntity garden;
}