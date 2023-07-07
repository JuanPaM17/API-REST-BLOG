package com.sistema.blog.spring.modelo;


import jakarta.persistence.*;

@Entity
@Table(name="comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_comentario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cuerpo")
    private String cuerpo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publicacion_id", nullable = false)
    private Publicacion publicacion;

    public Comentario() {
    }

    public Comentario(int id_comentario, String nombre, String cuerpo, Publicacion publicacion) {
        this.id_comentario = id_comentario;
        this.nombre = nombre;
        this.cuerpo = cuerpo;
        this.publicacion = publicacion;
    }

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id_comentario=" + id_comentario +
                ", nombre='" + nombre + '\'' +
                ", cuerpo='" + cuerpo + '\'' +
                ", publicacion=" + publicacion +
                '}';
    }
}
