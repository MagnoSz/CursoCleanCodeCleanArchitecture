package com.example.loja.infraestrutura.spring;

public abstract class BaseMapper<DATA, DOMINIO> {
    public abstract DOMINIO toDomain(DATA data) throws Exception;
    public abstract DATA toModel(DOMINIO dominio);
}
