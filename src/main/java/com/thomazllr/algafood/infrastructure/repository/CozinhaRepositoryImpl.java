package com.thomazllr.algafood.infrastructure.repository;

import com.thomazllr.algafood.domain.model.Cozinha;
import com.thomazllr.algafood.domain.repository.CozinhaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cozinha> listar() {
        return em.createQuery("from Cozinha", Cozinha.class).getResultList();
    }

    @Override
    public Cozinha buscar(Long id) {
        return em.find(Cozinha.class, id);
    }

    @Transactional
    @Override
    public Cozinha salvar(Cozinha cozinha) {
        return em.merge(cozinha);
    }

    @Transactional
    @Override
    public void excluir(Cozinha cozinha) {
        cozinha = buscar(cozinha.getId());
        em.remove(cozinha);
    }
}
