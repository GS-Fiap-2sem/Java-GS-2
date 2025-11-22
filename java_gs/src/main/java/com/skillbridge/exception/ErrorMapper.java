package com.skillbridge.exception;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.HashMap;
import java.util.Map;

@Provider
public class ErrorMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        Map<String, Object> erro = new HashMap<>();
        if (exception instanceof BusinessException) {
            erro.put("mensagem", exception.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(erro).type(MediaType.APPLICATION_JSON).build();
        } else {
            erro.put("mensagem", "Erro interno do servidor.");
            erro.put("detalhe", exception.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(erro).type(MediaType.APPLICATION_JSON).build();
        }
    }
}
