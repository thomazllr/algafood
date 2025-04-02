package com.thomazllr.algafood.infrastructure.repository;

import com.thomazllr.algafood.domain.model.FormaPagamento;
import com.thomazllr.algafood.domain.repository.FormaPagamentoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<FormaPagamento> listar() {
        return em.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
    }

    @Override
    public FormaPagamento buscar(Long id) {
        return em.find(FormaPagamento.class, id);
    }

    @Transactional
    @Override
    public FormaPagamento salvar(FormaPagamento formaPagamento) {
        return em.merge(formaPagamento);
    }

    @Transactional
    @Override
    public void excluir(FormaPagamento formaPagamento) {
        formaPagamento = buscar(formaPagamento.getId());
        em.remove(formaPagamento);
    }
}
