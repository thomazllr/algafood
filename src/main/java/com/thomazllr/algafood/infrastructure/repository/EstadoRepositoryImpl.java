package com.thomazllr.algafood.infrastructure.repository;

import com.thomazllr.algafood.domain.model.Estado;
import com.thomazllr.algafood.domain.repository.EstadoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class EstadoRepositoryImpl implements EstadoRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Estado> listar() {
        return em.createQuery("from Estado", Estado.class).getResultList();
    }

    @Override
    public Estado buscar(Long id) {
        return em.find(Estado.class, id);
    }

    @Transactional
    @Override
    public Estado salvar(Estado estado) {
        return em.merge(estado);
    }

    @Transactional
    @Override
    public void excluir(Estado estado) {
        estado = buscar(estado.getId());
        em.remove(estado);
    }
}
