package org.ldclrcq.infrastructure.in.rest.mapper;

import org.ldclrcq.domain.Garden;
import org.ldclrcq.infrastructure.in.rest.dto.CreateGardenDTO;
import org.ldclrcq.infrastructure.in.rest.dto.GardenDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface GardenMapper {
    @Mapping(source = "squaresByRow", target = "rows")
    GardenDTO toDTO(Garden model);

    Garden toDomain(CreateGardenDTO createDTO);
}
