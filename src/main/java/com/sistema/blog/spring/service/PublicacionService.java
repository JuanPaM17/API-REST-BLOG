package com.sistema.blog.spring.service;

import com.sistema.blog.spring.dto.PublicacionDTO;
import com.sistema.blog.spring.excepciones.ResourcesNotFoundExcepcion;
import com.sistema.blog.spring.interfazRepository.IPublicacionRepository;
import com.sistema.blog.spring.interfazService.IPublicacionService;
import com.sistema.blog.spring.modelo.Publicacion;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class PublicacionService implements IPublicacionService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IPublicacionRepository iPublicacionRepository;

    @Override
    public PublicacionDTO insertar(PublicacionDTO publicacionDTO) {
        // Convertimos de DTO a Modelo (Clase)
        Publicacion publicacion = dtoToPublicacion(publicacionDTO);

        Publicacion Enviarpublicacion = iPublicacionRepository.save(publicacion);

        // Convertimos de Modelo a DTO
        PublicacionDTO publicacionDTORespuesta = publicacionToDto(Enviarpublicacion);

        return publicacionDTORespuesta;
    }

    @Override
    public ArrayList<PublicacionDTO> listar() {
        ArrayList<Publicacion> listaPublicaciones = (ArrayList<Publicacion>) iPublicacionRepository.findAll();
        return (ArrayList<PublicacionDTO>) listaPublicaciones.stream().map(publicacion-> this.publicacionToDto(publicacion)).collect(Collectors.toList());
    }

    @Override
    public PublicacionDTO buscarId(int id) {
        Publicacion publicacion = iPublicacionRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundExcepcion("Publicion","id",id));
        return publicacionToDto(publicacion);
    }

    @Override
    public PublicacionDTO actualizar(PublicacionDTO publicacionDTO) {
        Publicacion publicacion = iPublicacionRepository.findById(publicacionDTO.getId()).orElseThrow(()-> new ResourcesNotFoundExcepcion("Publicion","id",publicacionDTO.getId()));

        publicacion.setTitulo(publicacionDTO.getTitulo());
        publicacion.setDescripcion(publicacionDTO.getDescripcion());

        Publicacion publicacionActualizada = iPublicacionRepository.save(publicacion);

        return publicacionToDto(publicacionActualizada);
    }

    @Override
    public void eliminar(int id) {
        Publicacion publicacion = iPublicacionRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundExcepcion("Publicion","id",id));
        iPublicacionRepository.delete(publicacion);
    }


    public PublicacionDTO publicacionToDto(Publicacion publicacion) {
        PublicacionDTO publicacionDto = modelMapper.map(publicacion,PublicacionDTO.class);
        return publicacionDto;
    }

    public Publicacion dtoToPublicacion(PublicacionDTO publicacionDTO) {
        Publicacion publicacion = modelMapper.map(publicacionDTO,Publicacion.class);
        return publicacion;
    }

}
