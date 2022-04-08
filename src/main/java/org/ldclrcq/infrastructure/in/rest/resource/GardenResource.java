package org.ldclrcq.infrastructure.in.rest.resource;

import org.ldclrcq.application.port.in.CreateGarden;
import org.ldclrcq.application.port.in.FetchGarden;
import org.ldclrcq.domain.exception.NotFoundException;
import org.ldclrcq.infrastructure.in.rest.dto.CreateGardenDTO;
import org.ldclrcq.infrastructure.in.rest.mapper.GardenMapper;

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
public class GardenResource {
    private final CreateGarden createGarden;
    private final FetchGarden fetchGarden;

    private final GardenMapper mapper;

    @Inject
    GardenResource(CreateGarden createGarden, FetchGarden fetchGarden, GardenMapper mapper) {
        this.createGarden = createGarden;
        this.fetchGarden = fetchGarden;
        this.mapper = mapper;
    }

    @POST
    @Transactional
    public Response createGarden(@Valid CreateGardenDTO dto) {
        final var garden = mapper.toDomain(dto);
        final var createdGarden = createGarden.execute(garden);
        final var createdDto = mapper.toDTO(createdGarden);

        return Response.status(Response.Status.CREATED).entity(createdDto).build();
    }

    @GET
    @Path("/{gardenId}")
    public Response getGarden(@PathParam("gardenId") @NotNull Long gardenId) throws NotFoundException {
        final var garden = fetchGarden.execute(gardenId);
        final var gardenDTO = mapper.toDTO(garden);

        return Response.ok(gardenDTO).build();
    }
}