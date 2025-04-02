package com.thomazllr.algafood.domain.repository;

import com.thomazllr.algafood.domain.model.Cozinha;
import com.thomazllr.algafood.domain.model.FormaPagamento;

import java.util.List;

public interface FormaPagamentoRepository {

    List<FormaPagamento> listar();

    FormaPagamento buscar(Long id);

    FormaPagamento salvar(FormaPagamento formaPagamento);

    void excluir(FormaPagamento formaPagamento);
}
