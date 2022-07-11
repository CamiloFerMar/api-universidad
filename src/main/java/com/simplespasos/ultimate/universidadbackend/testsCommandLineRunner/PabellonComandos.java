package com.simplespasos.ultimate.universidadbackend.testsCommandLineRunner;

import com.simplespasos.ultimate.universidadbackend.models.entities.Pabellon;
import com.simplespasos.ultimate.universidadbackend.services.contratos.PabellonDAO;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

//@Component
public class PabellonComandos implements CommandLineRunner {

//    @Autowired
    PabellonDAO service;


    @Override
    public void run(String... args) throws Exception {
        /*Direccion direccion = new Direccion("103", "15-45", "101012","tail", "1", "atlantico");
        Pabellon pabellon = new Pabellon(null, 40.5, "Los mamboking", direccion);

        Direccion direccion2 = new Direccion("104", "10-45", "111012","hola", "1", "bogota");
        Pabellon pabellon2 = new Pabellon(null, 30.0, "Los rolos", direccion2);

        Direccion direccion3 = new Direccion("103", "25-45", "101012","tail2", "1", "atlantico");
        Pabellon pabellon3 = new Pabellon(null, 40.5, "Los salseros", direccion3);

        service.save(pabellon);
        service.save(pabellon2);
        service.save(pabellon3);*/

        List<Pabellon> pabellons = (List<Pabellon>) service.findPabellonsByNombreContainsIgnoreCase("LAS FLores");

        for (Pabellon pabellones: pabellons) {
            System.out.println(pabellones.getNombre());
        }
    }


}
