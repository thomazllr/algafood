package com.thomazllr.algafood.domain.repository;

import com.thomazllr.algafood.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {

    List<Cozinha> listar();

    Cozinha buscar(Long id);

    Cozinha salvar(Cozinha cozinha);

    void excluir(Cozinha cozinha);
}
