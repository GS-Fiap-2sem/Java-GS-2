package com.skillbridge.resource;

import com.skillbridge.model.Usuario;
import com.skillbridge.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/api/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService service;

    @GET
    public Response listar() {
        List<Usuario> lista = service.listar();
        return Response.ok(lista).build();
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        Usuario u = service.buscar(id);
        if (u == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(u).build();
    }

    @POST
    public Response criar(@Valid Usuario usuario) {
        Usuario criado = service.criar(usuario);
        return Response.created(URI.create("/api/usuarios/" + criado.getId())).entity(criado).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, @Valid Usuario usuario) {
        Usuario atualizado = service.atualizar(id, usuario);
        return Response.ok(atualizado).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        service.deletar(id);
        return Response.noContent().build();
    }
}
