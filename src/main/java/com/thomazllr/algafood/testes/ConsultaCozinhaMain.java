package com.thomazllr.algafood.testes;

import com.thomazllr.algafood.Application;
import com.thomazllr.algafood.domain.model.Cozinha;
import com.thomazllr.algafood.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cozinhasRepository = context.getBean(CozinhaRepository.class);

        List<Cozinha> cozinhas = cozinhasRepository.listar();

        for (Cozinha cozinha : cozinhas) {
            System.out.println(cozinha.getId() + ": " + cozinha.getNome());
        }

        var cozinhaNova = new Cozinha();
        cozinhaNova.setNome("Brasileira");

        Cozinha cozinhaSalva = cozinhasRepository.salvar(cozinhaNova);

        System.out.println("Cozinha salva com sucesso! -> " + cozinhaSalva.getNome());

        var cozinhaBuscada = cozinhasRepository.buscar(2L);

        System.out.println("Cozinha buscada com sucesso com id 2! -> " + cozinhaBuscada.getNome());


    }
}
