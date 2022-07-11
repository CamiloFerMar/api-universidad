package com.simplespasos.ultimate.universidadbackend.repositories;

import com.simplespasos.ultimate.universidadbackend.models.entities.Aula;
import com.simplespasos.ultimate.universidadbackend.models.entities.Enumeradores.Pizarron;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AulaRepository extends CrudRepository<Aula, Integer> {
    Iterable<Aula> findAulasByPizarra(Pizarron pizarron);
    Iterable<Aula> findAulasByPabellon_Nombre(String nombre);
    Optional<Aula> findAulaByNumeroAula(Integer numero);
}
