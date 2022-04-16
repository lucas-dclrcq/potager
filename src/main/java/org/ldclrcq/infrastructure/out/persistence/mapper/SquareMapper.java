package org.ldclrcq.infrastructure.out.persistence.mapper;

import org.ldclrcq.domain.Square;
import org.ldclrcq.infrastructure.out.persistence.entity.SquareEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SquareMapper {
    SquareEntity toEntity(Square model);

    Square toDomain(SquareEntity entity);
}

