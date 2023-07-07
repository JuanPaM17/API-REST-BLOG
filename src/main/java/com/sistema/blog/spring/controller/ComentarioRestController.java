package com.sistema.blog.spring.controller;

import com.sistema.blog.spring.dto.ComentarioDTO;
import com.sistema.blog.spring.modelo.Comentario;
import com.sistema.blog.spring.service.ComentarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioRestController {

    @Autowired
    private ComentarioService comentarioService;


    @GetMapping("/{id_publicacion}")
    public ResponseEntity<ArrayList<ComentarioDTO>> listarComentarioPorPublicacion(
            @PathVariable(value = "id_publicacion") int id_publicacion){
        return new ResponseEntity<>(comentarioService.obtenerComentariosPorPublicacion(id_publicacion),HttpStatus.CREATED);
    }

    @GetMapping("/{id_publicacion}/{id_comentario}")
    public ResponseEntity<ComentarioDTO> listarComentarioPorId(
            @PathVariable(value = "id_publicacion") int id_publicacion,
            @PathVariable(value = "id_comentario") int id_comentario){
        return new ResponseEntity<>(comentarioService.obtenerComentarioPorId(id_publicacion,id_comentario),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id_comentario}")
    public ResponseEntity<ComentarioDTO> actualizarComentario(
            @PathVariable(value = "id_comentario") int id_comentario,
            @Valid @RequestBody ComentarioDTO comentarioDTO){
        return new ResponseEntity<>(comentarioService.actualizarComentario(id_comentario, comentarioDTO),HttpStatus.CREATED);
    }

    @PostMapping("/publicacion/{id_publicacion}")
    public ResponseEntity<ComentarioDTO> guardarComentario(
            @PathVariable(value = "id_publicacion") int id_publicacion,
            @Valid @RequestBody ComentarioDTO comentarioDTO){
        return new ResponseEntity<>(comentarioService.crearComentario(id_publicacion,comentarioDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarComentario(@PathVariable int id){
        comentarioService.eliminar(id);
        return new ResponseEntity<>("Comentario Eliminado con exito",HttpStatus.OK);
    }

}
