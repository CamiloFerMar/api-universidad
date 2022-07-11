package com.simplespasos.ultimate.universidadbackend.repositories;

import com.simplespasos.ultimate.universidadbackend.models.entities.Aula;
import com.simplespasos.ultimate.universidadbackend.models.entities.Enumeradores.Pizarron;
import com.simplespasos.ultimate.universidadbackend.models.entities.Pabellon;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static com.simplespasos.ultimate.universidadbackend.datos.DatosDummy.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;


@DataJpaTest
class AulaRepositoryTest {

    @Autowired
    AulaRepository aulaRepository;
    @Autowired
    PabellonRepository pabellonRepository;

    @BeforeEach
    void setUp() {
        aulaRepository.saveAll(List.of(aula(false), aula2()));
        pabellonRepository.save(pabellon(false));
    }

    @AfterEach
    void tearDown() {
        aulaRepository.deleteAll();
        pabellonRepository.deleteAll();
    }

    @Test
    @DisplayName("Buscar aulas por pizarra")
    void findAulasByPizarra() {
        System.out.println("Inicio 1");
        aulaRepository.findAll().forEach(aula -> System.out.println("aula = " + aula));
        //when
        List<Aula> expected = (List<Aula>)aulaRepository.findAulasByPizarra(Pizarron.PIZARRA_BLANCA);

        //then
        assertThat(expected.size() == 1).isTrue();
        
    }

    @Test
    @DisplayName("Buscar aula por nombre pabellon")
    void findAulasByPabellon_Nombre() {
        //Given

        Pabellon pabellon = pabellon(true);
        Aula aula = aula(true);
        aula.setPabellon(pabellon);

        aulaRepository.save(aula);
        pabellonRepository.save(pabellon);

        //when
        List<Aula> expected = (List<Aula>) aulaRepository.findAulasByPabellon_Nombre("Las aguilas");

        //Then
        assertThat(expected.size() == 1).isTrue();
    }

    @Test
    @DisplayName("Buscar aula por numero")
    void findAulaByNumeroAula() {
        System.out.println("Inicio 3");
        aulaRepository.findAll().forEach(aula -> System.out.println("aula = " + aula));
        //When
        Aula expected = aulaRepository.findAulaByNumeroAula(103).get();
        System.out.println(expected);

        //Then
        assertThat(expected.equals(aula(true))).isTrue();
    }
}