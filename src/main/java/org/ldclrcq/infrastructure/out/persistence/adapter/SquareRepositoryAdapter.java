package org.ldclrcq.infrastructure.out.persistence.adapter;

import org.ldclrcq.application.port.out.SquareRepository;
import org.ldclrcq.domain.Square;
import org.ldclrcq.infrastructure.out.persistence.mapper.SquareMapper;
import org.ldclrcq.infrastructure.out.persistence.panache.SquarePanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class SquareRepositoryAdapter implements SquareRepository {
    private final SquarePanacheRepository panacheRepository;
    private final SquareMapper mapper;

    @Inject
    SquareRepositoryAdapter(SquarePanacheRepository panacheRepository, SquareMapper mapper) {
        this.panacheRepository = panacheRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Square> findByIdAndOwner(Long id, String ownerId) {
        return Optional.empty();
    }

    @Override
    public Square update(Square square) {
        return null;
    }
}
