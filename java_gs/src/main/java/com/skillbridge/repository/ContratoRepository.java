package com.skillbridge.repository;

import com.skillbridge.model.Contrato;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ContratoRepository implements PanacheRepository<Contrato> {
    public List<Contrato> listarTodos() {
        return listAll();
    }
}
