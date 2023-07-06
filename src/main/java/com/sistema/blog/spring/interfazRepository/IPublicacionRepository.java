package com.sistema.blog.spring.interfazRepository;

import com.sistema.blog.spring.modelo.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPublicacionRepository extends JpaRepository<Publicacion,Integer> {
}
