package org.ldclrcq.infrastructure.out.persistence.mapper;

import org.ldclrcq.domain.Garden;
import org.ldclrcq.infrastructure.out.persistence.entity.GardenEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface GardenMapper {
    GardenEntity toEntity(Garden garden);

    Garden toDomain(GardenEntity entity);
}
