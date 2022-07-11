package com.simplespasos.ultimate.universidadbackend.repositories;

import com.simplespasos.ultimate.universidadbackend.models.entities.Pabellon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import static com.simplespasos.ultimate.universidadbackend.datos.DatosDummy.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class PabellonRepositoryTest {
    @Autowired
    PabellonRepository repository;

    @BeforeEach
    void setUp() {
        repository.saveAll(List.of(pabellon(false), pabellon2()));
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void findPabellonsByDireccion_LocalidadIgnoreCase() {
        //When
        List<Pabellon> expected = (List<Pabellon>) repository.findPabellonsByDireccion_LocalidadIgnoreCase("3");
        //Then
        assertThat(expected.size() == 2).isTrue();
    }

    @Test
    void findPabellonsByNombreContainsIgnoreCase() {
        //When
        List<Pabellon> expected = (List<Pabellon>) repository.findPabellonsByNombreContainsIgnoreCase("aguilas");
        //Then
        assertThat(expected.size() == 1).isTrue();
    }
}