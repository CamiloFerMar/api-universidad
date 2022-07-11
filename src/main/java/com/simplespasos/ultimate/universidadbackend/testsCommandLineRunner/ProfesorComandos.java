package com.simplespasos.ultimate.universidadbackend.testsCommandLineRunner;

import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import com.simplespasos.ultimate.universidadbackend.services.contratos.CarreraDAO;
import com.simplespasos.ultimate.universidadbackend.services.contratos.ProfesorDAO;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

//@Component
public class ProfesorComandos implements CommandLineRunner {

//    @Autowired
    private ProfesorDAO servicio;

//    @Autowired
    private CarreraDAO servicio2;

    @Override
    public void run(String... args) throws Exception {

        /*Set<Carrera> carrerasProfesor = new HashSet<>();

        for (int i = 5; i < 8; i++ ){
            Optional<Carrera> consulta = servicio2.findById(i);
            consulta.ifPresent(carrerasProfesor::add);
        }

        carrerasProfesor.forEach(System.out::println);

        Direccion direccion = new Direccion("Street2", "40", "130012", "Sanjose", "1", "Bolivar");

        Profesor profesor = new Profesor(5, "Libia", "Martinez", "45498740", direccion, new BigDecimal("2000000"));
        profesor.setCarreras(carrerasProfesor);

        servicio.save(profesor);*/

        List<Persona> lista = (List<Persona>) servicio.findProfesoresByCarrera("ingenieria industrial");

        lista.forEach(System.out::println);

    }
}
