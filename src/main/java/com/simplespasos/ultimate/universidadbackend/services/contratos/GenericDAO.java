package com.simplespasos.ultimate.universidadbackend.services.contratos;

import java.util.Optional;

public interface GenericDAO<E> {

    Optional<E> findById(Integer id);
    E save(E generic);
    Iterable<E> findAll();
    void deleteById(Integer id);

}
