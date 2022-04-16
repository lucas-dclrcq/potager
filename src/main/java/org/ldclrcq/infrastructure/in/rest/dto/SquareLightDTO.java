package org.ldclrcq.infrastructure.in.rest.dto;

import org.ldclrcq.domain.SquareType;

public record SquareLightDTO(Long id, SquareType type, PlantLightDTO plant) {
}
