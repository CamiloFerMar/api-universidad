package com.simplespasos.ultimate.universidadbackend.testsCommandLineRunner;

import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import com.simplespasos.ultimate.universidadbackend.services.contratos.AlumnosDAO;
import com.simplespasos.ultimate.universidadbackend.services.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

//@Component
public class AlumnoComandos implements CommandLineRunner {

    @Autowired
    private AlumnosDAO servicio;
    @Autowired
    private CarreraDAO servicio2;

    @Override
    public void run(String... args) throws Exception {

        /*Optional<Persona> consulta = servicio.findById(1);
        Alumno alumno = null;
        if (consulta.isPresent()){
            alumno = (Alumno)consulta.get();
        }

        Optional<Carrera> consulta2c= servicio2.findById(2);
        Carrera carrera = null;
        if (consulta2c.isPresent()){
            carrera = consulta2c.get();;
        }

        alumno.setCarrera(carrera);

        servicio.save(alumno);*/

        List<Persona> alumnos = (List<Persona>) servicio.buscarAlumnoCarrera("ingenieria de sistemas");
        if (alumnos.isEmpty()){
            System.out.println("No hay coincidencias");
        }else {
            alumnos.forEach(System.out::println);
        }
    }
}
