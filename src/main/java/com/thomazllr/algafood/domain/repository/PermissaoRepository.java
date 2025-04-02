package com.thomazllr.algafood.domain.repository;

import com.thomazllr.algafood.domain.model.Cozinha;
import com.thomazllr.algafood.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    List<Permissao> listar();

    Permissao buscar(Long id);

    Permissao salvar(Permissao permissao);

    void excluir(Permissao permissao);
}
