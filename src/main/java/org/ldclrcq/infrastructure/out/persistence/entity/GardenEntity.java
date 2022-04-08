package org.ldclrcq.infrastructure.out.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "garden")
public class GardenEntity extends PanacheEntity {
    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    public String name;
    @Column(name = "width")
    public Long width;

    @Column(name = "height")
    public Long height;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "garden")
    public List<SquareEntity> tiles;
}
