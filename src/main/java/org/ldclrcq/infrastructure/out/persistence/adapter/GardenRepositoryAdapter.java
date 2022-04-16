package org.ldclrcq.infrastructure.out.persistence.adapter;

import org.ldclrcq.application.port.out.GardenRepository;
import org.ldclrcq.domain.Garden;
import org.ldclrcq.infrastructure.out.persistence.mapper.GardenMapper;
import org.ldclrcq.infrastructure.out.persistence.panache.GardenPanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class GardenRepositoryAdapter implements GardenRepository {
    private final GardenPanacheRepository panacheRepository;
    private final GardenMapper mapper;

    @Inject
    GardenRepositoryAdapter(GardenPanacheRepository panacheRepository, GardenMapper mapper) {
        this.panacheRepository = panacheRepository;
        this.mapper = mapper;
    }

    @Override
    public Garden create(Garden garden) {
        final var entity = mapper.toEntity(garden);
        panacheRepository.persistAndFlush(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public Optional<Garden> findById(Long id) {
        return panacheRepository.findByIdOptional(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Garden> findForOwner(String ownerId) {
        return panacheRepository.find("ownerId", ownerId)
                .firstResultOptional()
                .map(mapper::toDomain);
    }

}
