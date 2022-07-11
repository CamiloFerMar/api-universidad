package com.simplespasos.ultimate.universidadbackend.repositories;

import com.simplespasos.ultimate.universidadbackend.models.entities.Empleado;
import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import com.simplespasos.ultimate.universidadbackend.models.entities.Profesor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.simplespasos.ultimate.universidadbackend.datos.DatosDummy.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class PersonaRepositoryTest {

    @Autowired
    @Qualifier("repositorioAlumno")
    PersonaRepository alumnoRepository;
    @Autowired
    @Qualifier("repositorioEmpleado")
    PersonaRepository empleadoRepository;
    @Autowired
    @Qualifier("repositorioProfesor")
    PersonaRepository profesorRepository;


    @Test
    void buscarNombreApellido() {
        //Given
        Persona save = empleadoRepository.save(empleado());

        //When
        Optional<Persona> expected = empleadoRepository.buscarNombreApellido(empleado().getNombre(), empleado().getApellido());

        //Then
        assertThat(expected.get()).isInstanceOf(Empleado.class);
        assertThat(expected.get()).isEqualTo(save);


    }

    @Test
    void buscarPorDNI() {
        //given
        Persona save = profesorRepository.save(profesor(false));

        //when
        Optional<Persona> expected = profesorRepository.buscarPorDNI(profesor(false).getDni());

        //then
        assertThat(expected.get()).isInstanceOf(Profesor.class);
        assertThat(expected.get()).isEqualTo(save);
    }

    @Test
    void buscarPorApellido() {
        //given
        Iterable<Persona> personas = alumnoRepository.saveAll(
                Arrays.asList(
                        alumno(),
                        alumno2(),
                        alumno3(),
                        alumno4())
        );

        //when
        String apellido = "Ardila";
        List<Persona> expected = (List<Persona>) alumnoRepository.buscarPorApellido(apellido);

        //then
        assertThat(expected.size() == 2).isTrue();
    }
}