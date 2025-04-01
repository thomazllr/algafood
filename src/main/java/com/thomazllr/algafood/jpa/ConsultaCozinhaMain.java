package com.thomazllr.algafood.jpa;

import com.thomazllr.algafood.Application;
import com.thomazllr.algafood.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cadastroCozinha = context.getBean(CadastroCozinha.class);

        List<Cozinha> cozinhas = cadastroCozinha.listaCozinhas();

        for (Cozinha cozinha : cozinhas) {
            System.out.println(cozinha.getId() + ": " + cozinha.getNome());
        }

        var cozinhaNova = new Cozinha();
        cozinhaNova.setNome("Brasileira");

        Cozinha cozinhaSalva = cadastroCozinha.salvarCozinha(cozinhaNova);

        System.out.println("Cozinha salva com sucesso! -> " + cozinhaSalva.getNome());

        var cozinhaBuscada = cadastroCozinha.buscarCozinha(2L);

        System.out.println("Cozinha buscada com sucesso com id 2! -> " + cozinhaBuscada.getNome());




    }
}
