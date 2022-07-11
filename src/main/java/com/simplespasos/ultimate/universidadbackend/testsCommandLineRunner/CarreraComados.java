package com.simplespasos.ultimate.universidadbackend.testsCommandLineRunner;

import com.simplespasos.ultimate.universidadbackend.models.entities.Carrera;
import com.simplespasos.ultimate.universidadbackend.services.contratos.CarreraDAO;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

//@Component
public class CarreraComados implements CommandLineRunner {

//    @Autowired
    private CarreraDAO servicio;

    @Override
    public void run(String... args) throws Exception {
        /*Carrera ingSistemas = new Carrera(null, "ingenieria de sistemas", 50, 5);
        Carrera ingElectronica = new Carrera(null, "ingenieria electronica", 50, 4);*/
        /*Carrera ingIndustrial = new Carrera(null, "ingenieria industrial", 50, 5);
        Carrera LicLenguas = new Carrera(null, "Licenciatura en lenguas", 50, 5);
        Carrera CienSociales = new Carrera(null, "Ciencias sociales", 50, 4);
        Carrera tecRedes = new Carrera(null, "Tecnologia en redes y sistemas", 40, 3);

        *//*servicio.save(ingSistemas);
        servicio.save(ingElectronica);*//*
        servicio.save(ingIndustrial);
        servicio.save(LicLenguas);
        servicio.save(CienSociales);
        servicio.save(tecRedes);*/

//        List<Carrera> carreras = (List<Carrera>) servicio.findCarrerasByNombreContainsIgnoreCase("ingeNIeria");
//        List<Carrera> carreras2 = (List<Carrera>) servicio.findCarrerasByCantidadAniosAfter(4);

//        carreras.forEach(System.out::println);
//        carreras2.forEach(System.out::println);

        List<Carrera> carreras = (List<Carrera>) servicio.buscarCarreraPorProfesorNombreYApellido("fredy", "fernandez");

        if (!carreras.isEmpty()){
            carreras.forEach(System.out::println);
        }else {
            System.out.println("Lista vacia");
        }


    }
}
