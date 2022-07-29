package com.crudprueba.demo.service;

import com.crudprueba.demo.entity.Libro;
import java.util.List;

public interface LibroServiceImpl {
    Libro create(Libro libro);
    Libro update(Libro libro);
    void delete(Long id);
    Libro findById(Long id);
    List<Libro> findAll();
}
