package com.simplespasos.ultimate.universidadbackend.services.implementaciones;

import com.simplespasos.ultimate.universidadbackend.repositories.AlumnoRepository;
import com.simplespasos.ultimate.universidadbackend.services.contratos.PersonaDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonaDAOImpTest {

    PersonaDAO personaDAO;
    @Mock
    AlumnoRepository alumnoRepository;

    @BeforeEach
    void setUp() {
        personaDAO = new PersonaDAOImp(alumnoRepository);
    }

    @Test
    void buscarNombreApellido() {

        //When
        personaDAO.buscarNombreApellido(anyString(), anyString());

        //Then
        verify(alumnoRepository).buscarNombreApellido(anyString(), anyString());
    }

    @Test
    void buscarPorDNI() {

        //When
        personaDAO.buscarPorDNI(anyString());

        //Then
        verify(alumnoRepository).buscarPorDNI(anyString());
    }

    @Test
    void buscarPorApellido() {

        //When
        personaDAO.buscarPorApellido(anyString());

        //Then
        verify(alumnoRepository).buscarPorApellido(anyString());
    }
}