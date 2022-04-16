package org.ldclrcq.application.port.out;

import org.ldclrcq.domain.Square;

import java.util.Optional;

public interface SquareRepository {
    Optional<Square> findByIdAndOwner(Long id, String ownerId);

    Square update(Square square);
}
