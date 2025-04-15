package com.thomazllr.algafood.domain.service;

import com.thomazllr.algafood.domain.exception.EntidadeEmUsoException;
import com.thomazllr.algafood.domain.model.Cozinha;
import com.thomazllr.algafood.domain.repository.CozinhaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CozinhaService {

    private final CozinhaRepository cozinhaRepository;

    public CozinhaService(CozinhaRepository cozinhaRepository) {
        this.cozinhaRepository = cozinhaRepository;
    }

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.salvar(cozinha);
    }

    public Cozinha buscar(Long id) {
        var cozinha = cozinhaRepository.buscar(id);

        if (cozinha == null) {
            throw new EntityNotFoundException("Entidade nao encontrada");
        }
        return cozinha;
    }

    public void excluir(Long id) {
        try {
            cozinhaRepository.excluir(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException("Ela está sendo utilizada e não pode ser excluida!");
        }
    }
}
