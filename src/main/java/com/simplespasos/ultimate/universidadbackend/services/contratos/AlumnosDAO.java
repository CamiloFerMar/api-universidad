package com.simplespasos.ultimate.universidadbackend.services.contratos;

import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;

public interface AlumnosDAO extends PersonaDAO{
    Iterable<Persona> buscarAlumnoCarrera(String nombre);
    Iterable<Persona> findAllAlumno();
}
