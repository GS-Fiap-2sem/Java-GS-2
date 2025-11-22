package com.skillbridge.service;

import com.skillbridge.model.Contrato;
import com.skillbridge.repository.ContratoRepository;
import com.skillbridge.repository.VagaRepository;
import com.skillbridge.repository.UsuarioRepository;
import com.skillbridge.exception.BusinessException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ContratoService {

    @Inject
    ContratoRepository repo;

    @Inject
    VagaRepository vagaRepo;

    @Inject
    UsuarioRepository usuarioRepo;

    public List<Contrato> listar() {
        return repo.listarTodos();
    }

    public Contrato buscar(Long id) {
        return repo.findById(id);
    }

    @Transactional
    public Contrato criar(Contrato c) {
        if (vagaRepo.findById(c.getIdVaga()) == null) {
            throw new BusinessException("Vaga não existe.");
        }
        if (usuarioRepo.findById(c.getIdAluno()) == null) {
            throw new BusinessException("Aluno não existe.");
        }
        if (!"aluno".equals(usuarioRepo.findById(c.getIdAluno()).getTipo())) {
            throw new BusinessException("O usuário informado não é um aluno.");
        }
        c.setStatus("aberto");
        repo.persist(c);
        return c;
    }

    @Transactional
    public Contrato atualizarStatus(Long id, String novoStatus) {
        Contrato c = repo.findById(id);
        if (c == null) {
            throw new BusinessException("Contrato não encontrado.");
        }
        if (!novoStatus.matches("aberto|em andamento|concluido|cancelado")) {
            throw new BusinessException("Status inválido.");
        }
        c.setStatus(novoStatus);
        repo.persist(c);
        return c;
    }

    @Transactional
    public void deletar(Long id) {
        Contrato c = repo.findById(id);
        if (c == null) {
            throw new BusinessException("Contrato não encontrado.");
        }
        repo.delete(c);
    }
}
