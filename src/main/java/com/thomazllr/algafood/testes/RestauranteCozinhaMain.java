package com.thomazllr.algafood.testes;

import com.thomazllr.algafood.Application;
import com.thomazllr.algafood.domain.model.Cozinha;
import com.thomazllr.algafood.domain.model.Restaurante;
import com.thomazllr.algafood.domain.repository.CozinhaRepository;
import com.thomazllr.algafood.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class RestauranteCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restauranteRepository = context.getBean(RestauranteRepository.class);

        var restauranteNovo = new Restaurante();
        restauranteNovo.setNome("Seara");
        restauranteNovo.setTaxaFrete(BigDecimal.TWO);

        Restaurante restauranteSalvo = restauranteRepository.salvar(restauranteNovo);

        System.out.println("Restaurante salva com sucesso! -> " + restauranteSalvo.getNome());

        var restauranteBuscado = restauranteRepository.buscar(1L);

        System.out.println("Cozinha buscada com sucesso com id! -> " + restauranteBuscado.getNome());


    }
}
