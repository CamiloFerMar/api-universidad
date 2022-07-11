package com.simplespasos.ultimate.universidadbackend.repositories;

import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Integer> {
    @Query("select p from Persona p where p.nombre = ?1 and p.apellido = ?2")
    Optional<Persona> buscarNombreApellido(String nombre, String apellido);
    @Query("select p from Persona p where p.dni = ?1")
    Optional<Persona> buscarPorDNI(String dni);
    @Query("select p from Persona p where p.apellido like %?1%")
    Iterable<Persona> buscarPorApellido(String apellido);
}
