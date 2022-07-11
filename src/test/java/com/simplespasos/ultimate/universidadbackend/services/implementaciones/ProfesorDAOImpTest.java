package com.simplespasos.ultimate.universidadbackend.services.implementaciones;

import com.simplespasos.ultimate.universidadbackend.repositories.ProfesorRepository;
import com.simplespasos.ultimate.universidadbackend.services.contratos.ProfesorDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ProfesorDAOImpTest {

    @MockBean
    ProfesorRepository profesorRepository;

    @Autowired
    ProfesorDAO profesorDAO;

    @Test
    void findProfesoresByCarrera() {
        //When
        profesorDAO.findProfesoresByCarrera(anyString());

        //Then
        verify(profesorRepository).findProfesoresByCarrera(anyString());
    }
}