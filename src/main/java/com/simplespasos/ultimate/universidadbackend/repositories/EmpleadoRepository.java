package com.simplespasos.ultimate.universidadbackend.repositories;

import com.simplespasos.ultimate.universidadbackend.models.entities.Enumeradores.TipoEmpleado;
import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioEmpleado")
public interface EmpleadoRepository extends PersonaRepository{

    @Query("select e from Empleado e where e.tipoEmpleado = ?1")
    Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);
    @Query("select e from Empleado e")
    Iterable<Persona> findAllEmpleado();
}
