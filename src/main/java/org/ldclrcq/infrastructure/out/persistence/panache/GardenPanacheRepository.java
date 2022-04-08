package org.ldclrcq.infrastructure.out.persistence.panache;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.ldclrcq.infrastructure.out.persistence.entity.GardenEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GardenPanacheRepository implements PanacheRepository<GardenEntity> {
}
