package com.thomazllr.algafood.infrastructure.repository;

import com.thomazllr.algafood.domain.model.Cidade;
import com.thomazllr.algafood.domain.repository.CidadeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CidadeRepositoryImpl implements CidadeRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cidade> listar() {
        return em.createQuery("select c from Cidade c", Cidade.class).getResultList();
    }

    @Override
    public Cidade buscar(Long id) {
        return em.find(Cidade.class, id);
    }

    @Transactional
    @Override
    public Cidade salvar(Cidade cidade) {
        return em.merge(cidade);
    }

    @Override
    public void excluir(Cidade cidade) {
        cidade = buscar(cidade.getId());
        em.remove(cidade);
    }
}
