package com.skillbridge.service;

import com.skillbridge.model.Usuario;
import com.skillbridge.repository.UsuarioRepository;
import com.skillbridge.exception.BusinessException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository repo;

    public List<Usuario> listar() {
        return repo.listarTodos();
    }

    public Usuario buscar(Long id) {
        return repo.findById(id);
    }

    @Transactional
    public Usuario criar(Usuario u) {

        if (u.getNome() == null || u.getNome().isBlank()) {
            throw new BusinessException("Nome é obrigatório.");
        }

        if (u.getEmail() == null || u.getEmail().isBlank()) {
            throw new BusinessException("Email é obrigatório.");
        }

        if (!u.getTipo().equals("estudante") && !u.getTipo().equals("empresa")) {
            throw new BusinessException("Tipo inválido. Use 'estudante' ou 'empresa'.");
        }

        if (repo.buscarPorEmail(u.getEmail()) != null) {
            throw new BusinessException("Email já cadastrado.");
        }

        repo.persist(u);
        return u;
    }

    @Transactional
    public Usuario atualizar(Long id, Usuario dados) {
        Usuario existente = repo.findById(id);

        if (existente == null) {
            throw new BusinessException("Usuário não encontrado.");
        }

        existente.setNome(dados.getNome());
        existente.setEmail(dados.getEmail());
        existente.setTipo(dados.getTipo());

        repo.persist(existente);
        return existente;
    }

    @Transactional
    public void deletar(Long id) {
        Usuario u = repo.findById(id);

        if (u == null) {
            throw new BusinessException("Usuário não encontrado.");
        }

        repo.delete(u);
    }
}