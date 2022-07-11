package com.simplespasos.ultimate.universidadbackend.services.implementaciones;

import com.simplespasos.ultimate.universidadbackend.models.entities.Enumeradores.TipoEmpleado;
import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import com.simplespasos.ultimate.universidadbackend.repositories.EmpleadoRepository;
import com.simplespasos.ultimate.universidadbackend.services.contratos.EmpleadoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.simplespasos.ultimate.universidadbackend.datos.DatosDummy.empleado2;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmpleadoDAOImpTest {

    EmpleadoDAO empleadoDAO;
    @Mock
    EmpleadoRepository empleadoRepository;

    @BeforeEach
    void setUp() {
        empleadoDAO = new EmpleadoDAOImp(empleadoRepository);
    }

    @Test
    void findEmpleadoByTipoEmpleado() {
        //given
        when(empleadoRepository.findEmpleadoByTipoEmpleado(TipoEmpleado.MANTENIMIENTO))
                .thenReturn(List.of(empleado2()));
        //when
        List<Persona> expected = (List<Persona>) empleadoDAO.findEmpleadoByTipoEmpleado(TipoEmpleado.MANTENIMIENTO);
        //then
        assertThat(expected.size() == 1).isTrue();
        verify(empleadoRepository).findEmpleadoByTipoEmpleado(TipoEmpleado.MANTENIMIENTO);
    }
}