package com.simplespasos.ultimate.universidadbackend.services.implementaciones;

import com.simplespasos.ultimate.universidadbackend.models.entities.Carrera;
import com.simplespasos.ultimate.universidadbackend.repositories.CarreraRepository;
import com.simplespasos.ultimate.universidadbackend.services.contratos.CarreraDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.simplespasos.ultimate.universidadbackend.datos.DatosDummy.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class CarreraDAOImpTest {

    CarreraDAO carreraDAO;
    CarreraRepository carreraRepository;


    @BeforeEach
    void setUp() {
        carreraRepository = mock(CarreraRepository.class);
        carreraDAO = new CarreraDAOImp(carreraRepository);
    }

    @Test
    void buscarCarreraPorProfesorNombreYApellido() {

        //Given
        when(carreraRepository.buscarCarreraPorProfesorNombreYApellido("fredy", "fernandez"))
                .thenReturn(Arrays.asList(carrera(true), carrera3(true)));

        //When
        List<Carrera> expected = (List<Carrera>) carreraDAO.buscarCarreraPorProfesorNombreYApellido("fredy", "fernandez");

        //then

        assertThat(expected.get(0)).isEqualTo(carrera(true));
        assertThat(expected.get(1)).isEqualTo(carrera3(true));
    }

    @Test
    void findCarrerasByNombreContains() {

        //Given
        String nombre = "Ingenieria";
        when(carreraRepository.findCarrerasByNombreContains(nombre))
                .thenReturn(Arrays.asList(carrera(true), carrera3(true)));

        //When
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContains(nombre);

        //Then
        assertThat(expected.get(0)).isEqualTo(carrera(true));
        assertThat(expected.get(1)).isEqualTo(carrera3(true));

        verify(carreraRepository).findCarrerasByNombreContains(nombre);
    }

    @Test
    void findCarrerasByNombreContainsIgnoreCase() {
        //Given
        String nombre = "Ingenieria";
        when(carreraRepository.findCarrerasByNombreContainsIgnoreCase(nombre))
                .thenReturn(Arrays.asList(carrera(true), carrera3(true)));

        //When
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase(nombre);

        //Then
        assertThat(expected.get(0)).isEqualTo(carrera(true));
        assertThat(expected.get(1)).isEqualTo(carrera3(true));

        verify(carreraRepository).findCarrerasByNombreContainsIgnoreCase(nombre);
    }

    @Test
    void findCarrerasByCantidadAniosAfter() {
        //Given
        int cantidad = 5;
        when(carreraRepository.findCarrerasByCantidadAniosAfter(cantidad))
                .thenReturn(Arrays.asList(carrera(true), carrera3(true)));

        //When
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByCantidadAniosAfter(cantidad);

        //Then
        assertThat(expected.get(0)).isEqualTo(carrera(true));
        assertThat(expected.get(1)).isEqualTo(carrera3(true));

        verify(carreraRepository).findCarrerasByCantidadAniosAfter(cantidad);
    }
}