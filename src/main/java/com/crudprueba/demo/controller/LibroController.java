package com.crudprueba.demo.controller;

import com.crudprueba.demo.entity.Libro;
import com.crudprueba.demo.exception.ModelNotFoundException;
import com.crudprueba.demo.service.LibroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;
    
    @GetMapping
    public ResponseEntity<List<Libro>> findAll(){
        return new ResponseEntity<> (libroService.findAll(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Libro> create(@RequestBody Libro libro){
        return new ResponseEntity<> (libroService.create(libro), HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Libro libro){
        libroService.update(libro);
        return new ResponseEntity<> (HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Libro> findById(@PathVariable("id") Long idLibro) throws ModelNotFoundException{
        Libro libro = libroService.findById(idLibro);
        if(libro == null){
            throw new ModelNotFoundException ("El Libro no existe.");
        }
        return new ResponseEntity<>(libroService.findById(idLibro), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long idLibro) throws ModelNotFoundException{
        // Consultar primero si el libro a eliminar existe.
        Libro libro = libroService.findById(idLibro);
        if(libro == null){
            throw new ModelNotFoundException ("El Libro que desea eliminar NO existe.");
        }
        libroService.delete(idLibro);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
