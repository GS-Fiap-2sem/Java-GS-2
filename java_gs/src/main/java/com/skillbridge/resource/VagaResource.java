package com.skillbridge.resource;

import com.skillbridge.model.Vaga;
import com.skillbridge.service.VagaService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/api/vagas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VagaResource {

    @Inject
    VagaService service;

    @GET
    public Response listar() {
        List<Vaga> lista = service.listar();
        return Response.ok(lista).build();
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        Vaga v = service.buscar(id);
        if (v == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(v).build();
    }

    @POST
    public Response criar(@Valid Vaga vaga) {
        Vaga criado = service.criar(vaga);
        return Response.created(URI.create("/api/vagas/" + criado.getId())).entity(criado).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, @Valid Vaga vaga) {
        Vaga atualizado = service.atualizar(id, vaga);
        return Response.ok(atualizado).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        service.deletar(id);
        return Response.noContent().build();
    }
}
