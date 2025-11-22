package com.skillbridge.repository;

import com.skillbridge.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public List<Usuario> listarTodos() {
        return listAll();
    }

    public Usuario buscarPorEmail(String email) {
        return find("email", email).firstResult();
    }
}
