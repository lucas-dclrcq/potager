package org.ldclrcq.infrastructure.out.persistence.panache;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.ldclrcq.infrastructure.out.persistence.entity.SquareEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SquarePanacheRepository implements PanacheRepository<SquareEntity> {
}
