package org.ldclrcq.application.usecase;

import org.jboss.logging.Logger;
import org.ldclrcq.application.port.in.CreateGarden;
import org.ldclrcq.application.port.out.GardenRepository;
import org.ldclrcq.domain.Garden;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CreateGardenUsecase implements CreateGarden {
    private final GardenRepository gardenRepository;

    @Inject
    CreateGardenUsecase(GardenRepository gardenRepository) {
        this.gardenRepository = gardenRepository;
    }

    @Override
    public Garden execute(Garden garden) {
        return gardenRepository.create(garden);
    }
}
