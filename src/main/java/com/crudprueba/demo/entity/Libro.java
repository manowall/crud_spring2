package com.crudprueba.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_libro;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Column(name = "paginas", nullable = false, length = 45)
    private String paginas;
    @Column(name = "autor", nullable = false, length = 45)
    private String autor;
    @Column(name = "genero", nullable = false, length = 45)
    private String genero;

    public long getId_libro() {
        return id_libro;
    }

    public void setId_libro(long id_libro) {
        this.id_libro = id_libro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
