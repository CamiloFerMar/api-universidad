package com.simplespasos.ultimate.universidadbackend.services.contratos;

import com.simplespasos.ultimate.universidadbackend.models.entities.Carrera;


public interface CarreraDAO extends GenericDAO<Carrera> {

    Iterable<Carrera> buscarCarreraPorProfesorNombreYApellido(String nombre, String apellido);
//  @Query("select c from Carrera c where c.nombre like %?1%")
    Iterable<Carrera> findCarrerasByNombreContains(String nombre);
//  @Query("select c from Carrera c where upper(c.nombre) like upper(?1)")
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
//  @Query("select c from Carrera c where c.cantidadAnios > ?1")
    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidad);

}
