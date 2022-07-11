package com.simplespasos.ultimate.universidadbackend.services.implementaciones;

import com.simplespasos.ultimate.universidadbackend.models.entities.Aula;
import com.simplespasos.ultimate.universidadbackend.models.entities.Enumeradores.Pizarron;
import com.simplespasos.ultimate.universidadbackend.repositories.AulaRepository;
import com.simplespasos.ultimate.universidadbackend.services.contratos.AulaDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static com.simplespasos.ultimate.universidadbackend.datos.DatosDummy.aula;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class AulaDAOImpTest {

    AulaDAO aulaDAO;
    AulaRepository aulaRepository;

    @BeforeEach
    void setUp() {
        aulaRepository = mock(AulaRepository.class);
        aulaDAO = new AulaDAOImp(aulaRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAulasByPizarra() {
        //given
        when(aulaRepository.findAulasByPizarra(Pizarron.PIZARRA_TIZA))
                .thenReturn(List.of(aula(true)));

        //when
        List<Aula> expected = (List<Aula>) aulaDAO.findAulasByPizarra(Pizarron.PIZARRA_TIZA);

        //then
        assertThat(expected.get(0)).isEqualTo(aula(true));
        verify(aulaRepository).findAulasByPizarra(Pizarron.PIZARRA_TIZA);
    }

    @Test
    void findAulasByPabellon_Nombre() {
        //given
        when(aulaRepository.findAulasByPabellon_Nombre("Las aguilas"))
                .thenReturn(List.of(aula(true)));
        //when
        List<Aula> expected = (List<Aula>) aulaDAO.findAulasByPabellon_Nombre("Las aguilas");

        //then
        assertThat(expected.get(0)).isEqualTo(aula(true));
        verify(aulaRepository).findAulasByPabellon_Nombre("Las aguilas");
    }

    @Test
    void findAulaByNumeroAula() {
        //given
        when(aulaRepository.findAulaByNumeroAula(103))
                .thenReturn(Optional.of(aula(true)));

        //when
        Aula expected = aulaDAO.findAulaByNumeroAula(103).get();

        //then
        assertThat(expected).isEqualTo(aula(true));
        verify(aulaRepository).findAulaByNumeroAula(103);
    }
}