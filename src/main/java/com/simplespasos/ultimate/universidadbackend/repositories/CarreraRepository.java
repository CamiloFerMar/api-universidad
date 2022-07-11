package com.simplespasos.ultimate.universidadbackend.repositories;

import com.simplespasos.ultimate.universidadbackend.models.entities.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarreraRepository extends CrudRepository<Carrera, Integer> {
    @Query("select c from Carrera c join fetch c.profesorSet p where upper(p.nombre) = upper(?1) and upper(p.apellido) = upper(?2)")
    Iterable<Carrera> buscarCarreraPorProfesorNombreYApellido(String nombre, String apellido);
    Iterable<Carrera> findCarrerasByNombreContains(String nombre);
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidad);
}
