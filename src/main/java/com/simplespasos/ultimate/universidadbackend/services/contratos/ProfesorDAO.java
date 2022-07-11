package com.simplespasos.ultimate.universidadbackend.services.contratos;

import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;

public interface ProfesorDAO extends PersonaDAO{

    Iterable<Persona> findProfesoresByCarrera(String carrera);
    Iterable<Persona> findAllProfesores();
}
