package com.skillbridge.repository;

import com.skillbridge.model.Vaga;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class VagaRepository implements PanacheRepository<Vaga> {
    public List<Vaga> listarTodas() {
        return listAll();
    }
}
