package com.thomazllr.algafood.infrastructure.repository;

import com.thomazllr.algafood.domain.model.Permissao;
import com.thomazllr.algafood.domain.repository.PermissaoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class PermissaoRepositoryImpl implements PermissaoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Permissao> listar() {
        return em.createQuery("from Permissao", Permissao.class).getResultList();
    }

    @Override
    public Permissao buscar(Long id) {
        return em.find(Permissao.class, id);
    }

    @Transactional
    @Override
    public Permissao salvar(Permissao permissao) {
        return em.merge(permissao);
    }

    @Override
    public void excluir(Permissao permissao) {
        permissao = buscar(permissao.getId());
        em.remove(permissao);
    }
}
