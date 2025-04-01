package com.thomazllr.algafood.jpa;

import com.thomazllr.algafood.domain.model.Cozinha;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceContext
    private EntityManager em;

    public List<Cozinha> listaCozinhas() {
        return em.createQuery("from Cozinha", Cozinha.class).getResultList();
    }
}
