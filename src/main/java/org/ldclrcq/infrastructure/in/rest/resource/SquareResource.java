package org.ldclrcq.infrastructure.in.rest.resource;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.ldclrcq.application.port.in.CultivateSquare;
import org.ldclrcq.domain.exception.NotFoundException;
import org.ldclrcq.infrastructure.in.rest.mapper.SquareMapper;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@RolesAllowed("user")
@Path("/squares")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SquareResource {
    private final CultivateSquare cultivateSquare;
    private final SquareMapper squareMapper;
    private final JsonWebToken token;

    @Inject
    SquareResource(CultivateSquare cultivateSquare, SquareMapper squareMapper, JsonWebToken token) {
        this.cultivateSquare = cultivateSquare;
        this.squareMapper = squareMapper;
        this.token = token;
    }

    @POST
    @Path("/{squareId}/cultivate")
    @Transactional
    public Response cultivate(@PathParam("squareId") @NotNull Long squareId) throws NotFoundException {
        final var cultivatedSquare = cultivateSquare.execute(token.getSubject(), squareId);
        return Response.ok(squareMapper.toDTO(cultivatedSquare)).build();
    }
}
