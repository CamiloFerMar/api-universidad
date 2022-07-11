package com.simplespasos.ultimate.universidadbackend.services.implementaciones;

import com.simplespasos.ultimate.universidadbackend.repositories.PabellonRepository;
import com.simplespasos.ultimate.universidadbackend.services.contratos.PabellonDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class PabellonDAOImpTest {

    @MockBean
    PabellonRepository pabellonRepository;
    @Autowired
    PabellonDAO pabellonDAO;


    @Test
    void findPabellonsByDireccion_LocalidadIgnoreCase() {
        //when
        pabellonDAO.findPabellonsByDireccion_LocalidadIgnoreCase(anyString());
        //then
        verify(pabellonRepository).findPabellonsByDireccion_LocalidadIgnoreCase(anyString());
    }

    @Test
    void findPabellonsByNombreContainsIgnoreCase() {
        //when
        pabellonDAO.findPabellonsByNombreContainsIgnoreCase(anyString());
        //then
        verify(pabellonRepository).findPabellonsByNombreContainsIgnoreCase(anyString());
    }
}