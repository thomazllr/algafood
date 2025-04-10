package com.thomazllr.algafood.api;

import com.thomazllr.algafood.domain.model.Cozinha;
import com.thomazllr.algafood.domain.repository.CozinhaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {


    private final CozinhaRepository repository;

    public CozinhaController(CozinhaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long id) {
        var cozinha = repository.buscar(id);
        return ResponseEntity.ok(cozinha);
    }

    @GetMapping
    public ResponseEntity<List<Cozinha>> buscarTodas() {
        return ResponseEntity.ok(repository.listar());
    }

    @PostMapping
    public ResponseEntity<Cozinha> salvar(@RequestBody Cozinha cozinha) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.salvar(cozinha));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long id, @RequestBody Cozinha cozinha) {
        var cozinhaEncontrada = repository.buscar(id);

        if (cozinhaEncontrada != null) {
            cozinhaEncontrada.setNome(cozinha.getNome());
            return ResponseEntity.ok(repository.salvar(cozinhaEncontrada));

        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }
}
