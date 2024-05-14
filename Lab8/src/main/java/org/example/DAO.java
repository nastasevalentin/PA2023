package org.example;

import java.util.List;

public interface DAO<T extends Model> {
    T create(T t);
    List<T> findAll();
    T findByName(String name);
    T findById(int id);
}