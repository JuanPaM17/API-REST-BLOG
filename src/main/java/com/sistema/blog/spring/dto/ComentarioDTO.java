package com.sistema.blog.spring.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ComentarioDTO {

    private int id_comentario;

    @NotEmpty
    @Size(min=3,message = "El nombre debe tener almenos 3 Caracteres")
    private String nombre;
    @NotEmpty
    @Size(min=5,message = "El cuerpo debe tener almenos 5 Caracteres")
    private String cuerpo;

    public ComentarioDTO() {
    }

    public ComentarioDTO(int id_comentario, String nombre, String cuerpo) {
        this.id_comentario = id_comentario;
        this.nombre = nombre;
        this.cuerpo = cuerpo;
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

    @Override
    public String toString() {
        return "ComentarioDTO{" +
                "id_comentario=" + id_comentario +
                ", nombre='" + nombre + '\'' +
                ", cuerpo='" + cuerpo + '\'' +
                '}';
    }
}
