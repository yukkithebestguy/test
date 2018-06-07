package com.test.books.service;

public interface BaseService<T,ID> {

    Iterable<T> findAll();

    T save(T var);

    T update(T var);

    T findById(ID var1);

    void deleteById(ID var1);

    void delete(T var1);
}
