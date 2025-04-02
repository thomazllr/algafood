package com.thomazllr.algafood.infrastructure.repository;

import com.thomazllr.algafood.domain.model.Restaurante;
import com.thomazllr.algafood.domain.repository.RestauranteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Restaurante> listar() {
        return em.createQuery("from Restaurante", Restaurante.class).getResultList()    ;
    }

    @Override
    public Restaurante buscar(Long id) {
        return em.find(Restaurante.class, id);
    }

    @Transactional
    @Override
    public Restaurante salvar(Restaurante restaurante) {
        return em.merge(restaurante);
    }

    @Override
    public void excluir(Restaurante restaurante) {
        restaurante = buscar(restaurante.getId());
        em.remove(restaurante);
    }
}
