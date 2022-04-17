package org.ldclrcq.application.usecase;

import org.jboss.logging.Logger;
import org.ldclrcq.application.port.in.CultivateSquare;
import org.ldclrcq.application.port.out.SquareRepository;
import org.ldclrcq.domain.Square;
import org.ldclrcq.domain.SquareType;
import org.ldclrcq.domain.exception.NotFoundException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CultivateSquareUsecase implements CultivateSquare {
    private static final Logger LOG = Logger.getLogger(CultivateSquareUsecase.class);
    private final SquareRepository squareRepository;

    @Inject
    CultivateSquareUsecase(SquareRepository squareRepository) {
        this.squareRepository = squareRepository;
    }

    @Override
    public Square execute(String ownerId, Long squareId) throws NotFoundException {
        final var square = squareRepository.findByIdAndOwner(squareId, ownerId)
                .orElseThrow(() -> new NotFoundException(Square.class, squareId.toString()));

        LOG.infof("Setting square %d in garden %d as CULTIVATED", squareId, square.getGardenId());

        square.setType(SquareType.CULTIVATED);

        return squareRepository.update(square);
    }
}
