package com.sistema.blog.spring.dto;

import com.sistema.blog.spring.modelo.Publicacion;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PublicacionDTO {

    private int id_publicacion;
    private String titulo;
    private String descripcion;
    @Column(name="contenido", nullable = false)
    private String contenido;

    public PublicacionDTO(int id, String titulo, String descripcion, String contenido) {
        this.id_publicacion = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.contenido = contenido;
    }

    public PublicacionDTO() {
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
