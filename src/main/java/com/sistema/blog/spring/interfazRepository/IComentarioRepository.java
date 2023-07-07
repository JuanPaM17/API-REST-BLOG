package com.sistema.blog.spring.interfazRepository;

import com.sistema.blog.spring.dto.ComentarioDTO;
import com.sistema.blog.spring.modelo.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentario,Integer> {

  ArrayList<Comentario> findByPublicacionId(int idPublicacion);

}
