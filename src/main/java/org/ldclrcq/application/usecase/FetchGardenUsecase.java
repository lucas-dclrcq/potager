package org.ldclrcq.application.usecase;

import org.ldclrcq.application.port.in.FetchGarden;
import org.ldclrcq.application.port.out.GardenRepository;
import org.ldclrcq.domain.Garden;
import org.ldclrcq.domain.exception.NotFoundException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class FetchGardenUsecase implements FetchGarden {
    private final GardenRepository gardenRepository;

    @Inject
    FetchGardenUsecase(GardenRepository gardenRepository) {
        this.gardenRepository = gardenRepository;
    }

    @Override
    public Garden execute(String ownerId) throws NotFoundException {
        final var forOwner = gardenRepository.findForOwner(ownerId);
        return forOwner
                .orElseThrow(() -> new NotFoundException(Garden.class, ownerId));
    }
}
