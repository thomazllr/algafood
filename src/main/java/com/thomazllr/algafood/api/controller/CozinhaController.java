package com.thomazllr.algafood.api.controller;

import com.thomazllr.algafood.domain.exception.EntidadeEmUsoException;
import com.thomazllr.algafood.domain.model.Cozinha;
import com.thomazllr.algafood.domain.repository.CozinhaRepository;
import com.thomazllr.algafood.domain.service.CozinhaService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cozinhas")
public class CozinhaController {

    private final CozinhaRepository repository;
    private final CozinhaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long id) {
        var cozinha = repository.buscar(id);

        if (cozinha == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(cozinha);
    }

    @GetMapping
    public ResponseEntity<List<Cozinha>> buscarTodas() {
        return ResponseEntity.ok(repository.listar());
    }

    @PostMapping
    public ResponseEntity<Cozinha> salvar(@RequestBody Cozinha cozinha) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(cozinha));
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        try {
            service.excluir(id);
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
