package com.simplespasos.ultimate.universidadbackend.services.contratos;

import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;

import java.util.Optional;


public interface PersonaDAO extends GenericDAO<Persona> {

    Optional<Persona> buscarNombreApellido(String nombre, String apellido);
    Optional<Persona> buscarPorDNI(String dni);
    Iterable<Persona> buscarPorApellido(String apellido);
}
