package org.ldclrcq.infrastructure.in.rest.configuration;

import org.ldclrcq.domain.exception.BusinessException;
import org.ldclrcq.domain.exception.NotFoundException;

import javax.ws.rs.core.Response;
import java.util.Arrays;

public enum ErrorStatusMapping {
    NOT_FOUND(NotFoundException.class, Response.Status.NOT_FOUND);

    private final Class<? extends BusinessException> exceptionClass;
    private final Response.Status httpStatus;

    ErrorStatusMapping(Class<? extends BusinessException> exceptionClass, Response.Status httpStatus) {
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    public static Response.Status getHttpStatusFor(Class<? extends BusinessException> exceptionClass) {
        return Arrays.stream(values()).filter(exceptionClass::equals)
                .findAny()
                .map(errorStatusMapping -> errorStatusMapping.httpStatus)
                .orElse(Response.Status.INTERNAL_SERVER_ERROR);
    }
}
