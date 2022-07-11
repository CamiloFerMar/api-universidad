package com.simplespasos.ultimate.universidadbackend.services.implementaciones;

import com.simplespasos.ultimate.universidadbackend.models.entities.Aula;
import com.simplespasos.ultimate.universidadbackend.models.entities.Enumeradores.Pizarron;
import com.simplespasos.ultimate.universidadbackend.repositories.AulaRepository;
import com.simplespasos.ultimate.universidadbackend.services.contratos.AulaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AulaDAOImp extends GenericDAOImp<Aula, AulaRepository> implements AulaDAO {

    @Autowired
    public AulaDAOImp(AulaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Aula> findAulasByPizarra(Pizarron pizarron) {
        return repository.findAulasByPizarra(pizarron);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Aula> findAulasByPabellon_Nombre(String nombre) {
        return repository.findAulasByPabellon_Nombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Aula> findAulaByNumeroAula(Integer numero) {
        return repository.findAulaByNumeroAula(numero);
    }
}
