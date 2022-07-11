package com.simplespasos.ultimate.universidadbackend.repositories;

import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioProfesor")
public interface ProfesorRepository extends PersonaRepository{
    @Query("select p from Profesor p join fetch p.carreras c where c.nombre = ?1")
    Iterable<Persona> findProfesoresByCarrera(String carrera);
    @Query("select p from Profesor p")
    Iterable<Persona> findAllProfesor();
}
