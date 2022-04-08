package org.ldclrcq.infrastructure.in.rest.resource;

import org.ldclrcq.application.port.in.CreateGarden;
import org.ldclrcq.infrastructure.in.rest.dto.CreateGardenDTO;
import org.ldclrcq.infrastructure.in.rest.mapper.GardenMapper;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/gardens")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GardenResource {

    private final CreateGarden createGarden;
    private final GardenMapper mapper;

    GardenResource(CreateGarden createGarden, GardenMapper mapper) {
        this.createGarden = createGarden;
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
}