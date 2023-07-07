package com.sistema.blog.spring.dto;

import com.sistema.blog.spring.modelo.Comentario;
import com.sistema.blog.spring.modelo.Publicacion;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Set;

public class PublicacionDTO {

    private int id_publicacion;
    private String titulo;
    private String descripcion;

    private Set<Comentario> comentarios;

    public PublicacionDTO(int id, String titulo, String descripcion) {
        this.id_publicacion = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
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

    @Override
    public String toString() {
        return "Publicacion{" +
                "id=" + id_publicacion +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
