package com.sistema.blog.spring.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourcesNotFoundExcepcion extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String nombre_recurso;
    private String nombre_campo;
    private int valor_campo;

    public ResourcesNotFoundExcepcion(String nombre_recurso, String nombre_campo, int valor_campo) {
        super(String.format("%s No encontrado con : %s : %s", nombre_recurso, nombre_campo, valor_campo));
        this.nombre_recurso = nombre_recurso;
        this.nombre_campo = nombre_campo;
        this.valor_campo = valor_campo;
    }

    public String getNombre_recurso() {
        return nombre_recurso;
    }

    public void setNombre_recurso(String nombre_recurso) {
        this.nombre_recurso = nombre_recurso;
    }

    public String getNombre_campo() {
        return nombre_campo;
    }

    public void setNombre_campo(String nombre_campo) {
        this.nombre_campo = nombre_campo;
    }

    public int getValor_campo() {
        return valor_campo;
    }

    public void setValor_campo(int valor_campo) {
        this.valor_campo = valor_campo;
    }
}
