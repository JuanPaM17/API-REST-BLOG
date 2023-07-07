package com.sistema.blog.spring.interfazService;

import com.sistema.blog.spring.dto.ComentarioDTO;
import com.sistema.blog.spring.modelo.Comentario;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


public interface IComentarioSevice  {

   public ComentarioDTO crearComentario(int id_publicacion, ComentarioDTO comentarioDTO);

   public ArrayList<ComentarioDTO> obtenerComentariosPorPublicacion(int id_publicacion);

   public ComentarioDTO obtenerComentarioPorId(int id_publicacion,int comentario_id);

   public ComentarioDTO actualizarComentario(int id_comentario,ComentarioDTO comentarioDTO);

   public void eliminar(int id);

}
