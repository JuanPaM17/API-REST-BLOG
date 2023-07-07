package com.sistema.blog.spring.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sistema.blog.spring.dto.PublicacionDTO;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="publicacion",uniqueConstraints = {@UniqueConstraint(columnNames ={"titulo"})})
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="titulo", nullable = false)
    private String titulo;
    @Column(name="descripcion", nullable = false)
    private String descripcion;

    @JsonBackReference
    @OneToMany(mappedBy = "publicacion",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Comentario> comentarios = new HashSet<>();

    public Publicacion(int id_publicacion, String titulo, String descripcion) {
        this.id = id_publicacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Publicacion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
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
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
