package com.simplespasos.ultimate.universidadbackend.repositories;

import com.simplespasos.ultimate.universidadbackend.models.entities.Carrera;
import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import com.simplespasos.ultimate.universidadbackend.models.entities.Profesor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.*;

import static com.simplespasos.ultimate.universidadbackend.datos.DatosDummy.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ProfesorRepositoryTest {

    @Autowired
    @Qualifier("repositorioProfesor")
    PersonaRepository profesorRepository;
    @Autowired
    CarreraRepository carreraRepository;

    @Test
    void findProfesoresByCarrera() {
        //Given
        Iterable<Persona> personas = profesorRepository.saveAll(
                Arrays.asList(
                        profesor(false),
                        profesor2(),
                        profesor3())
        );

        Carrera carrera = carreraRepository.save(carrera(false));

        personas.forEach(profesor -> ((Profesor)profesor).setCarreras(new HashSet<>(List.of(carrera))));
        //profesorRepository.saveAll(personas);


        //When
        String nombre = "Ingenieria en sistema";
        List<Persona> expected = (List<Persona>) ((ProfesorRepository) profesorRepository).findProfesoresByCarrera(nombre);
        expected.forEach(profesor -> System.out.println(profesor.toString()));
        //Then
        assertThat(expected.size() == 3).isTrue();
    }
}