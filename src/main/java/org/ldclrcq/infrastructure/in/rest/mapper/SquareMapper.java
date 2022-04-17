package org.ldclrcq.infrastructure.in.rest.mapper;

import org.ldclrcq.domain.Square;
import org.ldclrcq.infrastructure.in.rest.dto.SquareLightDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SquareMapper {
    SquareLightDTO toDTO(Square model);
}
