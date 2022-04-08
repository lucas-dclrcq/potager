package org.ldclrcq.infrastructure.in.rest.mapper;

import org.ldclrcq.domain.Garden;
import org.ldclrcq.infrastructure.in.rest.dto.CreateGardenDTO;
import org.ldclrcq.infrastructure.in.rest.dto.GardenDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface GardenMapper {
    GardenDTO toDTO(Garden model);

    Garden toDomain(CreateGardenDTO createDTO);

    Garden toDomain(GardenDTO dto);
}
