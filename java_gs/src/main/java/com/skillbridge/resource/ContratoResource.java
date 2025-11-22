package com.skillbridge.resource;

import com.skillbridge.model.Contrato;
import com.skillbridge.service.ContratoService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/api/contratos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContratoResource {

    @Inject
    ContratoService service;

    @GET
    public Response listar() {
        List<Contrato> lista = service.listar();
        return Response.ok(lista).build();
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        Contrato c = service.buscar(id);
        if (c == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(c).build();
    }

    @POST
    public Response criar(@Valid Contrato contrato) {
        Contrato criado = service.criar(contrato);
        return Response.created(URI.create("/api/contratos/" + criado.getId())).entity(criado).build();
    }

    @PUT
    @Path("/{id}/status")
    public Response atualizarStatus(@PathParam("id") Long id, String novoStatus) {
        Contrato atualizado = service.atualizarStatus(id, novoStatus);
        return Response.ok(atualizado).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        service.deletar(id);
        return Response.noContent().build();
    }
}
