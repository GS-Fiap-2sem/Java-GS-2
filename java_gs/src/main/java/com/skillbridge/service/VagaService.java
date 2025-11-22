package com.skillbridge.service;

import com.skillbridge.model.Vaga;
import com.skillbridge.repository.VagaRepository;
import com.skillbridge.repository.UsuarioRepository;
import com.skillbridge.exception.BusinessException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class VagaService {

    @Inject
    VagaRepository repo;

    @Inject
    UsuarioRepository usuarioRepo;

    public List<Vaga> listar() {
        return repo.listarTodas();
    }

    public Vaga buscar(Long id) {
        return repo.findById(id);
    }

    @Transactional
    public Vaga criar(Vaga v) {
        if (v.getTitulo() == null || v.getTitulo().isBlank()) {
            throw new BusinessException("Título é obrigatório.");
        }
        if (usuarioRepo.findById(v.getIdEmpresa()) == null) {
            throw new BusinessException("Empresa não encontrada.");
        }
        repo.persist(v);
        return v;
    }

    @Transactional
    public Vaga atualizar(Long id, Vaga dados) {
        Vaga existente = repo.findById(id);
        if (existente == null) {
            throw new BusinessException("Vaga não encontrada.");
        }
        existente.setTitulo(dados.getTitulo());
        existente.setDescricao(dados.getDescricao());
        existente.setLocalizacao(dados.getLocalizacao());
        existente.setRemuneracao(dados.getRemuneracao());
        repo.persist(existente);
        return existente;
    }

    @Transactional
    public void deletar(Long id) {
        Vaga v = repo.findById(id);
        if (v == null) {
            throw new BusinessException("Vaga não encontrada.");
        }
        repo.delete(v);
    }
}
