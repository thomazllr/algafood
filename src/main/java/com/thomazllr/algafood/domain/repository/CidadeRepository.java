package com.thomazllr.algafood.domain.repository;

import com.thomazllr.algafood.domain.model.Cidade;

import java.util.List;

public interface CidadeRepository {

    List<Cidade> listar();

    Cidade buscar(Long id);

    Cidade salvar(Cidade cidade);

    void excluir(Cidade cidade);
}
