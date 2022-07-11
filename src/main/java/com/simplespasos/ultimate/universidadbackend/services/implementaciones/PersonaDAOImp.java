package com.simplespasos.ultimate.universidadbackend.services.implementaciones;

import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import com.simplespasos.ultimate.universidadbackend.repositories.PersonaRepository;
import com.simplespasos.ultimate.universidadbackend.services.contratos.PersonaDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonaDAOImp extends GenericDAOImp<Persona, PersonaRepository> implements PersonaDAO {


    public PersonaDAOImp(PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarNombreApellido(String nombre, String apellido) {
        return repository.buscarNombreApellido(nombre, apellido);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorDNI(String dni) {
        return repository.buscarPorDNI(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarPorApellido(String apellido) {
        return repository.buscarPorApellido(apellido);
    }
}
