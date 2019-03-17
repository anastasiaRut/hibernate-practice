package com.it.dao;

import java.util.List;

public interface GenericDAO<T, U> {

    T getOne(U id);

    void delete(U id);

    void save(T entity);

    void update(T entity);

    List<T> findAll(Integer firstResult, Integer maxResult);

}
