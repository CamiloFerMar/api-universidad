package com.simplespasos.ultimate.universidadbackend.services.contratos;

import com.simplespasos.ultimate.universidadbackend.models.entities.Pabellon;

public interface PabellonDAO extends GenericDAO<Pabellon> {
    Iterable<Pabellon> findPabellonsByDireccion_LocalidadIgnoreCase(String localidad);
    Iterable<Pabellon> findPabellonsByNombreContainsIgnoreCase(String nombre);
}
