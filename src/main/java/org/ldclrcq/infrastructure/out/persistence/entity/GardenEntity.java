package org.ldclrcq.infrastructure.out.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "garden")
public class GardenEntity extends PanacheEntity {
    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    public String name;

    @Column(name = "owner_id", columnDefinition = "VARCHAR(36)")
    public String ownerId;

    @Column(name = "width")
    public Long width;

    @Column(name = "height")
    public Long height;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "garden_id")
    public List<SquareEntity> squares;
}
