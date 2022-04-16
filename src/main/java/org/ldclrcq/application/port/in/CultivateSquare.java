package org.ldclrcq.application.port.in;

import org.ldclrcq.domain.Square;
import org.ldclrcq.domain.exception.NotFoundException;

public interface CultivateSquare {
    Square execute(String ownerId, Long squareId) throws NotFoundException;
}
