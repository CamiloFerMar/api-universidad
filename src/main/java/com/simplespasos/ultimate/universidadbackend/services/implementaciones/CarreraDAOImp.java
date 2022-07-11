package com.simplespasos.ultimate.universidadbackend.services.implementaciones;

import com.simplespasos.ultimate.universidadbackend.models.entities.Carrera;
import com.simplespasos.ultimate.universidadbackend.repositories.CarreraRepository;
import com.simplespasos.ultimate.universidadbackend.services.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarreraDAOImp extends GenericDAOImp<Carrera, CarreraRepository> implements CarreraDAO {

    @Autowired
    public CarreraDAOImp(CarreraRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> buscarCarreraPorProfesorNombreYApellido(String nombre, String apellido) {
        return repository.buscarCarreraPorProfesorNombreYApellido(nombre, apellido);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNombreContains(String nombre) {
        return repository.findCarrerasByNombreContains(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre) {
        return repository.findCarrerasByNombreContainsIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidad) {
        return repository.findCarrerasByCantidadAniosAfter(cantidad);
    }
}
