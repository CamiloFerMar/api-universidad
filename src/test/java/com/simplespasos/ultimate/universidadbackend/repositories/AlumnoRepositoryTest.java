package com.simplespasos.ultimate.universidadbackend.repositories;

import com.simplespasos.ultimate.universidadbackend.models.entities.Alumno;
import com.simplespasos.ultimate.universidadbackend.models.entities.Carrera;
import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static com.simplespasos.ultimate.universidadbackend.datos.DatosDummy.*;
import static com.simplespasos.ultimate.universidadbackend.datos.DatosDummy.alumno4;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class AlumnoRepositoryTest {

    @Autowired
    @Qualifier("repositorioAlumno")
    PersonaRepository alumnoRepository;
    @Autowired
    CarreraRepository carreraRepository;

    @Test
    void buscarAlumnoCarrera() {
        //given
        Iterable<Persona> personas = alumnoRepository.saveAll(
                Arrays.asList(
                        alumno(),
                        alumno2(),
                        alumno3(),
                        alumno4())
        );

        Carrera carrera = carreraRepository.save(carrera(false));

        personas.forEach(alumno -> ((Alumno)alumno).setCarrera(carrera));

        alumnoRepository.saveAll(personas);

        //when
        String profesion = "Ingenieria en sistema";
        List<Persona> expected = (List<Persona>) ((AlumnoRepository) alumnoRepository).buscarAlumnoCarrera(profesion);

        //then
        assertThat(expected.size() == 4).isTrue();
    }
    @Test
    void buscarAlumnoCarreraSinValores() {
        //given
        Iterable<Persona> personas = alumnoRepository.saveAll(
                Arrays.asList(
                        alumno(),
                        alumno2(),
                        alumno3(),
                        alumno4())
        );

        Carrera carrera = carreraRepository.save(carrera(false));

        personas.forEach(alumno -> ((Alumno)alumno).setCarrera(carrera));

        alumnoRepository.saveAll(personas);

        //when
        String profesion = "Ingenieria en Alimentos";
        List<Persona> expected = (List<Persona>) ((AlumnoRepository) alumnoRepository).buscarAlumnoCarrera(profesion);

        //then
        assertThat(expected.isEmpty()).isTrue();
    }
}