package com.sistema.blog.spring.controller;

import com.sistema.blog.spring.dto.PublicacionDTO;
import com.sistema.blog.spring.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicionRestController {

    @Autowired
    private PublicacionService publicacionService;

    @PostMapping
    public ResponseEntity<PublicacionDTO> guardarPublicacion(@RequestBody PublicacionDTO publicacionDTO){
        return new ResponseEntity<>(publicacionService.insertar(publicacionDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ArrayList<PublicacionDTO>> obtenerPublicaciones(){
        return new ResponseEntity<>(publicacionService.listar(),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicacionDTO> obtenerPublicionId(@PathVariable int id){
        return new ResponseEntity<>(publicacionService.buscarId(id),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PublicacionDTO> actualizarPublicacion(@RequestBody PublicacionDTO publicacionDTO){
        return new ResponseEntity<>(publicacionService.actualizar(publicacionDTO),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPublicacion(@PathVariable int id){
        publicacionService.eliminar(id);
        return new ResponseEntity<>("Publicacion Eliminada con exito",HttpStatus.OK);
    }

}
