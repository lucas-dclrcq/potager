package org.ldclrcq.infrastructure.out.persistence.adapter;

import org.hibernate.SessionFactory;
import org.ldclrcq.application.port.out.SquareRepository;
import org.ldclrcq.domain.Square;
import org.ldclrcq.infrastructure.out.persistence.entity.SquareEntity;
import org.ldclrcq.infrastructure.out.persistence.mapper.SquareMapper;
import org.ldclrcq.infrastructure.out.persistence.panache.SquarePanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;

@ApplicationScoped
public class SquareRepositoryAdapter implements SquareRepository {
    private final SquarePanacheRepository panacheRepository;
    private final SquareMapper mapper;
    private final EntityManager entityManager;

    @Inject
    SquareRepositoryAdapter(SquarePanacheRepository panacheRepository, SquareMapper mapper, EntityManager entityManager) {
        this.panacheRepository = panacheRepository;
        this.mapper = mapper;
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Square> findByIdAndOwner(Long id, String ownerId) {
        final var squareEntityTypedQuery = entityManager
                .createQuery("""
                        select sq
                        from square sq
                        join garden g on sq.gardenId = g.id
                        where sq.id = :squareId and g.ownerId = :ownerId
                        """, SquareEntity.class)
        .setParameter("squareId", id)
        .setParameter("ownerId", ownerId);
        final var squareEntity = squareEntityTypedQuery
                .getSingleResult();

        return Optional.ofNullable(squareEntity)
                .map(mapper::toDomain);
    }

    @Override
    public Square update(Square square) {
        final var toUpdateEntity = mapper.toEntity(square);
        final var updated = entityManager.merge(toUpdateEntity);

        updated.persistAndFlush();

        return mapper.toDomain(updated);
    }
}
