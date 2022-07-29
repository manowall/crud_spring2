package com.crudprueba.demo.service;

import com.crudprueba.demo.entity.Libro;
import com.crudprueba.demo.repository.LibroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService implements LibroServiceImpl{

    @Autowired
    private LibroRepository libroRepo;
    
    @Override
    public Libro create(Libro libro) {
        return libroRepo.save(libro);
    }

    @Override
    public Libro update(Libro libro) {
        return libroRepo.save(libro);
    }

    @Override
    public void delete(Long id) {
        libroRepo.deleteById(id);
    }

    @Override
    public Libro findById(Long id) {
        Optional<Libro> libroOpcional = libroRepo.findById(id);
        return libroOpcional.orElse(null);
    }

    @Override
    public List<Libro> findAll() {
        return libroRepo.findAll();
    }
    
}
