package com.simplespasos.ultimate.universidadbackend.repositories;

import com.simplespasos.ultimate.universidadbackend.models.entities.Carrera;
import com.simplespasos.ultimate.universidadbackend.models.entities.Profesor;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.simplespasos.ultimate.universidadbackend.datos.DatosDummy.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CarreraRepositoryTest {

    @Autowired
    CarreraRepository repository;

    @Qualifier("repositorioProfesor")
    @Autowired
    PersonaRepository profesorRepository;

    @BeforeEach
    void setUp() {
        repository.save(carrera(false));
        repository.save(carrera2());
        repository.save(carrera3(false));
        repository.save(carrera4());
        profesorRepository.save(profesor(false));
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void buscarCarreraPorProfesorNombreYApellido() {
        //Given
        Profesor profesor = profesor(true);
        Set<Carrera> listaCarreras = new HashSet<Carrera>(List.of(carrera(true), carrera3(true)));
        profesor.setCarreras(listaCarreras);
        System.out.println("profesor = " + profesor);
        profesorRepository.save(profesor);

        //when
        Iterable<Carrera> expected = repository.buscarCarreraPorProfesorNombreYApellido("fredy", "fernandez");
        expected.forEach( carrera -> System.out.println("carrera = " + carrera));

        //then
        assertThat(((List<Carrera>)expected).size() == 2).isTrue();
    }

    @Test
    @DisplayName("Buscar carrera por nombre")
    void findCarrerasByNombreContains() {
        //Given
       /* repository.save(DatosDummy.carrera());
        repository.save(DatosDummy.carrera2());
        repository.save(DatosDummy.carrera3());
        repository.save(DatosDummy.carrera4());*/

        //when
        Iterable<Carrera> expected = repository.findCarrerasByNombreContains("sistema");

        //then
        assertThat(((List<Carrera>)expected).size() == 2).isTrue();
    }

    @Test
    @DisplayName("Buscar carrera por nombre ignorando case")
    void findCarrerasByNombreContainsIgnoreCase() {

        //given
        /*repository.save(DatosDummy.carrera());
        repository.save(DatosDummy.carrera2());
        repository.save(DatosDummy.carrera3());
        repository.save(DatosDummy.carrera4());*/

        //when
        List<Carrera> expected = (List<Carrera>) repository.findCarrerasByNombreContainsIgnoreCase("liceNciatura");

        //then
        assertThat(expected.size() == 2).isTrue();
    }

    @Test
    @DisplayName("Buscar carrera por cantidad de anios")
    void findCarrerasByCantidadAniosAfter() {

        //given
        /*repository.save(DatosDummy.carrera());
        repository.save(DatosDummy.carrera2());
        repository.save(DatosDummy.carrera3());
        repository.save(DatosDummy.carrera4());*/

        //when
        List<Carrera> expected = (List<Carrera>) repository.findCarrerasByCantidadAniosAfter(4);

        //then
        assertThat(expected.size() == 2).isTrue();
    }
}