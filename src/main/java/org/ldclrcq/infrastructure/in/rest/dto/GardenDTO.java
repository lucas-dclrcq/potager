package org.ldclrcq.infrastructure.in.rest.dto;

import java.util.List;

public record GardenDTO(Long id, String ownerId, String name, Long height, Long width, List<SquareRowDTO> rows) {
}
