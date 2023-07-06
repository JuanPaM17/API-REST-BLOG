package com.sistema.blog.spring.modelo;

import com.sistema.blog.spring.dto.PublicacionDTO;
import jakarta.persistence.*;

@Entity
@Table(name="publicacion",uniqueConstraints = {@UniqueConstraint(columnNames ={"titulo"})})
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_publicacion;

    @Column(name="titulo", nullable = false)
    private String titulo;
    @Column(name="descripcion", nullable = false)
    private String descripcion;
    @Column(name="contenido", nullable = false)
    private String contenido;

    public Publicacion(int id_publicacion, String titulo, String descripcion, String contenido) {
        this.id_publicacion = id_publicacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.contenido = contenido;
    }

    public Publicacion() {
    }

    public int getId() {
        return id_publicacion;
    }

    public void setId(int id) {
        this.id_publicacion = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Publicacion{" +
                "id=" + id_publicacion +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", contenido='" + contenido + '\'' +
                '}';
    }
}
