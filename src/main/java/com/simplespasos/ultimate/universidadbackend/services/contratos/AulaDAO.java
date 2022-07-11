package com.simplespasos.ultimate.universidadbackend.services.contratos;

import com.simplespasos.ultimate.universidadbackend.models.entities.Aula;
import com.simplespasos.ultimate.universidadbackend.models.entities.Enumeradores.Pizarron;

import java.util.Optional;

public interface AulaDAO extends GenericDAO<Aula>{
    Iterable<Aula> findAulasByPizarra(Pizarron pizarron);
    Iterable<Aula> findAulasByPabellon_Nombre(String nombre);
    Optional<Aula> findAulaByNumeroAula(Integer numero);

}
