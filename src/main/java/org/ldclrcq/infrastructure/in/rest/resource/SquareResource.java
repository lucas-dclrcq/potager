package org.ldclrcq.infrastructure.in.rest.resource;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.ldclrcq.application.port.in.CultivateSquare;
import org.ldclrcq.domain.Square;
import org.ldclrcq.domain.exception.NotFoundException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/squares")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SquareResource {
    private final CultivateSquare cultivateSquare;
    private final JsonWebToken token;

    @Inject
    SquareResource(CultivateSquare cultivateSquare, JsonWebToken token) {
        this.cultivateSquare = cultivateSquare;
        this.token = token;
    }

    @PUT
    @Path("/{squareId}")
    public Response getOne(@PathParam("squareId") @NotNull Long squareId) throws NotFoundException {
        final var updatedSquare = cultivateSquare.execute(token.getSubject(), squareId);
        return Response.ok().build();
    }
}
