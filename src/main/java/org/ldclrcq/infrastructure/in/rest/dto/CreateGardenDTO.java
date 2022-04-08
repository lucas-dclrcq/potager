package org.ldclrcq.infrastructure.in.rest.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record CreateGardenDTO(
        @NotEmpty
        String name,
        @Min(1)
        @NotNull
        Long width,
        @Min(1)
        @NotNull
        Long height) {
}
