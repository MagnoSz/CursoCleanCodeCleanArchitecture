package com.example.loja.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BaseController<T, ID> {

    private JpaRepository<T, ID> repository;

    protected BaseController(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<T> listar() {
        return repository.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody T objeto) {
        repository.save(objeto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable ID id) {
        repository.deleteById(id);
    }

}
