package org.ldclrcq.application.port.out;

import org.ldclrcq.domain.Garden;

import java.util.Optional;

public interface GardenRepository {
    Garden create(Garden garden);

    Optional<Garden> findById(Long id);
}
