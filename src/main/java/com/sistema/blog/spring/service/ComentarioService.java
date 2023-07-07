package com.sistema.blog.spring.service;

import com.sistema.blog.spring.dto.ComentarioDTO;
import com.sistema.blog.spring.excepciones.BlogAppException;
import com.sistema.blog.spring.excepciones.ResourcesNotFoundExcepcion;
import com.sistema.blog.spring.interfazRepository.IComentarioRepository;
import com.sistema.blog.spring.interfazRepository.IPublicacionRepository;
import com.sistema.blog.spring.interfazService.IComentarioSevice;
import com.sistema.blog.spring.modelo.Comentario;
import com.sistema.blog.spring.modelo.Publicacion;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;


@Service
public class ComentarioService implements IComentarioSevice {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IPublicacionRepository iPublicacionRepository;

    @Autowired
    private IComentarioRepository iComentarioRepository;

    @Override
    public ComentarioDTO crearComentario(int id_publicacion, ComentarioDTO comentarioDTO) {
        Comentario comentario = mapearComentario(comentarioDTO);
        Publicacion publicacion = iPublicacionRepository.findById(id_publicacion).orElseThrow(()-> new ResourcesNotFoundExcepcion("Publicion","id",id_publicacion));
        comentario.setPublicacion(publicacion);

        Comentario nuevoComentario = iComentarioRepository.save(comentario);
        return mapearDTO(nuevoComentario);
    }

    @Override
    public ArrayList<ComentarioDTO> obtenerComentariosPorPublicacion(int id_publicacion) {
        ArrayList<Comentario> listaComentario = iComentarioRepository.findByPublicacionId(id_publicacion);
        return (ArrayList<ComentarioDTO>) listaComentario.stream()
                .map(comentario -> mapearDTO(comentario))
                .collect(Collectors.toList());
    }

    @Override
    public ComentarioDTO obtenerComentarioPorId(int id_publicacion, int comentario_id) {
        Publicacion publicacion = iPublicacionRepository.findById(id_publicacion).orElseThrow(()-> new ResourcesNotFoundExcepcion("Publicion","id",id_publicacion));
        Comentario comentario = iComentarioRepository.findById(comentario_id).orElseThrow(()-> new ResourcesNotFoundExcepcion("Comentario","id",comentario_id));
        if (!comentario.getPublicacion().equals(publicacion)){
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"El comentario no pernece a la publicacion");
        }
        return mapearDTO(comentario);
    }

    @Override
    public ComentarioDTO actualizarComentario(int id_comentario, ComentarioDTO comentarioDTO) {
        Comentario comentario = iComentarioRepository.findById(id_comentario).orElseThrow(()-> new ResourcesNotFoundExcepcion("Comentario","id",id_comentario));
        if (comentario.getCuerpo().equals(null)){
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"El comentario no no existe");
        }
        comentario.setNombre(comentarioDTO.getNombre());
        comentario.setCuerpo(comentarioDTO.getCuerpo());
        Comentario comentarioActualizado = iComentarioRepository.save(comentario);
        return mapearDTO(comentarioActualizado);
    }

    @Override
    public void eliminar(int id) {
        Comentario Comentario = iComentarioRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundExcepcion("Comentario","id",id));
        iComentarioRepository.delete(Comentario);
    }


    private ComentarioDTO mapearDTO(Comentario comentario){
        ComentarioDTO comentarioDTO = modelMapper.map(comentario,ComentarioDTO.class);
        return comentarioDTO;
    }

    private Comentario mapearComentario(ComentarioDTO ComentarioDTO){
        Comentario Comentario = modelMapper.map(ComentarioDTO,Comentario.class);
        return Comentario;
    }
}
