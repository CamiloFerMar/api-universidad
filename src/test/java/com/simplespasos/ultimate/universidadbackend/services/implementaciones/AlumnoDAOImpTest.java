package com.simplespasos.ultimate.universidadbackend.services.implementaciones;

import com.simplespasos.ultimate.universidadbackend.repositories.AlumnoRepository;
import com.simplespasos.ultimate.universidadbackend.services.contratos.AlumnosDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class AlumnoDAOImpTest {

    @MockBean
    AlumnoRepository alumnoRepository;
    @Autowired
    AlumnosDAO alumnosDAO;

    @BeforeEach
    void setUp() {
    }

    @Test
    void buscarAlumnoCarrera() {
        //When
        alumnosDAO.buscarAlumnoCarrera(anyString());

        //Then
        verify(alumnoRepository).buscarAlumnoCarrera(anyString());
    }
}