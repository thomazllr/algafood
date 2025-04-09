package com.thomazllr.algafood.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "taxa_frete")
    private BigDecimal taxaFrete;

    @ManyToOne
    @JoinColumn
    private Cozinha cozinha;

    public Restaurante(){
    }

    public Restaurante(Long id, String nome, BigDecimal taxaFrete, Cozinha cozinha) {
        this.id = id;
        this.nome = nome;
        this.taxaFrete = taxaFrete;
        this.cozinha = cozinha;
    }

    public Long getId() {
        return id;
    }

    public Restaurante setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Restaurante setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public BigDecimal getTaxaFrete() {
        return taxaFrete;
    }

    public Restaurante setTaxaFrete(BigDecimal taxaFrete) {
        this.taxaFrete = taxaFrete;
        return this;
    }

    public Cozinha getCozinha() {
        return cozinha;
    }

    public Restaurante setCozinha(Cozinha cozinha) {
        this.cozinha = cozinha;
        return this;
    }
}
