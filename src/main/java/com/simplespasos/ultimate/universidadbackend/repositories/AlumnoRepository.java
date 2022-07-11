package com.simplespasos.ultimate.universidadbackend.repositories;

import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioAlumno")
public interface AlumnoRepository extends PersonaRepository{
    @Query("select a from Alumno a where a.carrera.nombre = ?1")
    Iterable<Persona> buscarAlumnoCarrera(String nombre);
    @Query("select a from Alumno a")
    Iterable<Persona> findAllAlumno();
}
