package com.simplespasos.ultimate.universidadbackend.repositories;

import static com.simplespasos.ultimate.universidadbackend.datos.DatosDummy.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.simplespasos.ultimate.universidadbackend.models.entities.Enumeradores.TipoEmpleado;
import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;


@DataJpaTest
class EmpleadoRepositoryTest {

    @Autowired
    @Qualifier("repositorioEmpleado")
    PersonaRepository repository;

    @Test
    void findEmpleadoByTipoEmpleado() {

        //given
        repository.saveAll(
                List.of(empleado(), empleado2())
        );

        //When
        List<Persona> expected = (List<Persona>) ((EmpleadoRepository)repository).findEmpleadoByTipoEmpleado(TipoEmpleado.MANTENIMIENTO);
        expected.forEach(empleado -> System.out.println("empleado = " + empleado));

        //Then
        assertThat(expected.size() == 1).isTrue();

    }
}