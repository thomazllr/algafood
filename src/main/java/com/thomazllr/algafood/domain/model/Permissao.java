package com.thomazllr.algafood.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Permissao(Long id) {
        this.id = id;
    }

    public Permissao(){
    }

    public Long getId() {
        return id;
    }

    public Permissao setId(Long id) {
        this.id = id;
        return this;
    }
}
