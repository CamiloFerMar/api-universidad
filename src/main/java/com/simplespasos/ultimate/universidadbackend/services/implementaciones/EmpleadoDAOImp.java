package com.simplespasos.ultimate.universidadbackend.services.implementaciones;

import com.simplespasos.ultimate.universidadbackend.models.entities.Enumeradores.TipoEmpleado;
import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import com.simplespasos.ultimate.universidadbackend.repositories.EmpleadoRepository;
import com.simplespasos.ultimate.universidadbackend.repositories.PersonaRepository;
import com.simplespasos.ultimate.universidadbackend.services.contratos.EmpleadoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoDAOImp extends PersonaDAOImp implements EmpleadoDAO {

    @Autowired
    public EmpleadoDAOImp(@Qualifier("repositorioEmpleado")PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado) {
        return ((EmpleadoRepository)repository).findEmpleadoByTipoEmpleado(tipoEmpleado);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findAllEmpleado() {
        return ((EmpleadoRepository)repository).findAllEmpleado();
    }
}
