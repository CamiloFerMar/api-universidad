package com.simplespasos.ultimate.universidadbackend.services.implementaciones;

import com.simplespasos.ultimate.universidadbackend.models.entities.Pabellon;
import com.simplespasos.ultimate.universidadbackend.repositories.PabellonRepository;
import com.simplespasos.ultimate.universidadbackend.services.contratos.PabellonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PabellonDAOImp extends GenericDAOImp<Pabellon, PabellonRepository> implements PabellonDAO {

    @Autowired
    public PabellonDAOImp(PabellonRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Pabellon> findPabellonsByDireccion_LocalidadIgnoreCase(String localidad) {
        return repository.findPabellonsByDireccion_LocalidadIgnoreCase(localidad);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Pabellon> findPabellonsByNombreContainsIgnoreCase(String nombre) {
        return repository.findPabellonsByNombreContainsIgnoreCase(nombre);
    }
}
