package org.ldclrcq.application.port.out;

import org.ldclrcq.domain.Garden;

public interface GardenRepository {
    Garden create(Garden garden);
}
