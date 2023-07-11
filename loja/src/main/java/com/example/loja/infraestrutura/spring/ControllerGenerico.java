package com.example.loja.infraestrutura.spring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

public abstract class ControllerGenerico <T, ID, M> {

    private final RepositoryGenerico<T, ID, M> repository;
    private final BaseMapper<T, M> mapper;

    protected ControllerGenerico(RepositoryGenerico<T, ID, M> repository, BaseMapper<T, M> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @GetMapping
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<T>> listar() {
        List<T> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<T> buscarPorId(@PathVariable ID id) {
        Optional<T> optionalEntity = repository.findById(id);
        return optionalEntity.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<T> criar(@RequestBody M objeto) {
        T objetoModel = mapper.toModel(objeto);
        repository.save(objetoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(objetoModel);
    }

    @PutMapping("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<T> atualizar(@PathVariable ID id, @RequestBody M objeto) {
        Optional<T> objetoExistente = repository.findById(id);
        return objetoExistente.isPresent() ? ResponseEntity.ok(repository.save(mapper.toModel(objeto))) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> deletar (@PathVariable ID id){
        Optional<T> objeto = repository.findById(id);

        return objeto.map(t -> {
            repository.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
