package com.sistema.blog.spring.interfazService;

import com.sistema.blog.spring.dto.PublicacionDTO;

import java.util.ArrayList;

public interface IPublicacionService {

    public PublicacionDTO insertar(PublicacionDTO publicacionDTO);

    public ArrayList<PublicacionDTO> listar();

    public PublicacionDTO buscarId(int id);

    public PublicacionDTO actualizar(PublicacionDTO publicacionDTO);

    public void eliminar(int id);

}
