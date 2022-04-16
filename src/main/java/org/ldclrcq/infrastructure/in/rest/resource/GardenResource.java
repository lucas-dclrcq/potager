package org.ldclrcq.infrastructure.in.rest.resource;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.ldclrcq.application.port.in.CreateGarden;
import org.ldclrcq.application.port.in.FetchGarden;
import org.ldclrcq.domain.exception.NotFoundException;
import org.ldclrcq.infrastructure.in.rest.dto.CreateGardenDTO;
import org.ldclrcq.infrastructure.in.rest.mapper.GardenMapper;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/gardens")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class GardenResource {
    private final CreateGarden createGarden;
    private final FetchGarden fetchGarden;
    private final GardenMapper mapper;
    private final JsonWebToken token;

    @Inject
    GardenResource(CreateGarden createGarden, FetchGarden fetchGarden, GardenMapper mapper, JsonWebToken token) {
        this.createGarden = createGarden;
        this.fetchGarden = fetchGarden;
        this.mapper = mapper;
        this.token = token;
    }

    @POST
    @Transactional
    @RolesAllowed("user")
    public Response createGarden(@Valid CreateGardenDTO dto) {
        final var ownerId = token.getSubject();
        final var garden = mapper.toDomain(dto);
        garden.setOwnerId(ownerId);
        final var createdGarden = createGarden.execute(garden);
        final var createdDto = mapper.toDTO(createdGarden);

        return Response.status(Response.Status.CREATED).entity(createdDto).build();
    }

    @GET
    @RolesAllowed("user")
    @Transactional
    public Response getGarden() throws NotFoundException {
        final var ownerId = token.getSubject();
        final var garden = fetchGarden.execute(ownerId);
        final var gardenDTO = mapper.toDTO(garden);

        return Response.ok(gardenDTO).build();
    }
}