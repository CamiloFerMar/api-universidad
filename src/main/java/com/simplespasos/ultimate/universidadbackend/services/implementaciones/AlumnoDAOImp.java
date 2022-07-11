package com.simplespasos.ultimate.universidadbackend.services.implementaciones;

import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import com.simplespasos.ultimate.universidadbackend.repositories.AlumnoRepository;
import com.simplespasos.ultimate.universidadbackend.repositories.PersonaRepository;
import com.simplespasos.ultimate.universidadbackend.services.contratos.AlumnosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AlumnoDAOImp extends PersonaDAOImp implements AlumnosDAO {

    @Autowired
    public AlumnoDAOImp(@Qualifier("repositorioAlumno")PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarAlumnoCarrera(String nombre) {
        return ((AlumnoRepository)repository).buscarAlumnoCarrera(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findAllAlumno() {
        return ((AlumnoRepository)repository).findAllAlumno();
    }
}
