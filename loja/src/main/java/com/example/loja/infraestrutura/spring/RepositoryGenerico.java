package com.example.loja.infraestrutura.spring;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class RepositoryGenerico <T, ID> {

    protected JpaRepository<T, ID> repository;

    public RepositoryGenerico(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T salvar(T entity) {
        return repository.save(entity);
    }

    public Optional<T> buscarPorId(ID id) {
        return repository.findById(id);
    }

    public List<T> buscarTodos() {
        return repository.findAll();
    }

    public void deletarPorId(ID id) {
        repository.deleteById(id);
    }

}
