package com.simplespasos.ultimate.universidadbackend.repositories;

import com.simplespasos.ultimate.universidadbackend.models.entities.Pabellon;
import org.springframework.data.repository.CrudRepository;

public interface PabellonRepository extends CrudRepository<Pabellon, Integer> {
    Iterable<Pabellon> findPabellonsByDireccion_LocalidadIgnoreCase(String localidad);
    Iterable<Pabellon> findPabellonsByNombreContainsIgnoreCase(String nombre);
}
