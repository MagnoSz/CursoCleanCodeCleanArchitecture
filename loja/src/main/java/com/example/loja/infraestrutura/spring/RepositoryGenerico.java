package com.example.loja.infraestrutura.spring;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class RepositoryGenerico <T, ID, M> {

    protected JpaRepository<T, ID> repository;
    protected BaseMapper<T, M> mapper;

    public RepositoryGenerico(JpaRepository<T, ID> repository, BaseMapper<T, M> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

}
