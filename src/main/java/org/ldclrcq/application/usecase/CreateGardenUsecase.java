package org.ldclrcq.application.usecase;

import org.jboss.logging.Logger;
import org.ldclrcq.application.port.in.CreateGarden;
import org.ldclrcq.application.port.out.GardenRepository;
import org.ldclrcq.domain.Garden;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CreateGardenUsecase implements CreateGarden {
    private final static Logger LOG = Logger.getLogger(CreateGardenUsecase.class);

    private final GardenRepository gardenRepository;

    @Inject
    CreateGardenUsecase(GardenRepository gardenRepository) {
        this.gardenRepository = gardenRepository;
    }

    @Override
    public Garden execute(Garden garden) {
        garden.createSquares();
        final var createdGarden = gardenRepository.create(garden);
        LOG.infof("Created garden with id %s for user %s", createdGarden.getId(), createdGarden.getOwnerId());
        return createdGarden;
    }
}
