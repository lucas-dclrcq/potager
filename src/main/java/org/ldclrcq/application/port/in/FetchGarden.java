package org.ldclrcq.application.port.in;

import org.ldclrcq.domain.Garden;
import org.ldclrcq.domain.exception.NotFoundException;

public interface FetchGarden {
    Garden execute(Long gardenId) throws NotFoundException;
}
