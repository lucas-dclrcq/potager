package org.ldclrcq.infrastructure.in.rest.configuration;

import org.ldclrcq.domain.exception.BusinessException;
import org.ldclrcq.infrastructure.in.rest.dto.ErrorDTO;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomExceptionHandler implements ExceptionMapper<BusinessException> {
    @Override
    public Response toResponse(BusinessException e) {
        final var errorStatus = ErrorStatusMapping.getHttpStatusFor(e.getClass());
        return Response.status(errorStatus).entity(new ErrorDTO(e.getMessage())).build();
    }
}
