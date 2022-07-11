package com.simplespasos.ultimate.universidadbackend.services.implementaciones;

import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import com.simplespasos.ultimate.universidadbackend.repositories.PersonaRepository;
import com.simplespasos.ultimate.universidadbackend.repositories.ProfesorRepository;
import com.simplespasos.ultimate.universidadbackend.services.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesorDAOImp extends PersonaDAOImp implements ProfesorDAO {

    @Autowired
    public ProfesorDAOImp(@Qualifier("repositorioProfesor") PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findProfesoresByCarrera(String carrera) {
        return ((ProfesorRepository)repository).findProfesoresByCarrera(carrera);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findAllProfesores() {
        return ((ProfesorRepository)repository).findAllProfesor();
    }
}
