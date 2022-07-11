package com.simplespasos.ultimate.universidadbackend.testsCommandLineRunner;

import com.simplespasos.ultimate.universidadbackend.models.entities.Aula;
import com.simplespasos.ultimate.universidadbackend.services.contratos.AulaDAO;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

//@Component
public class AulaComandos implements CommandLineRunner {

//    @Autowired
    private AulaDAO servicio;

    @Override
    public void run(String... args) throws Exception {

//        Aula aula = new Aula(null, 303, "34X29", 40, Pizarron.PIZARRA_BLANCA);

//        servicio.save(aula);
//        List<Aula> lista = (List<Aula>) servicio.findAulasByPizarra(Pizarron.PIZARRA_BLANCA);
        List<Aula> lista = (List<Aula>) servicio.findAulasByPabellon_Nombre("Las gardenia");

        if (!lista.isEmpty()){
            lista.forEach(System.out::println);
        }else {
            System.out.println("lista vacia");
        }

        /*Direccion direccion = new Direccion("50", "San luis", "101010","deil", "2", "bolivar");
        Pabellon pabellon = new Pabellon(null, 45.9, "Las flores", direccion);
        Optional<Aula> consulta = servicio.findAulaByNumeroAula(303);
        Aula aula = null;
        if (consulta.isPresent()){
            aula = consulta.get();
            System.out.println(aula.toString());
            aula.setPabellon(pabellon);
            servicio.save(aula);
        }else {
            System.out.println("Aula no encontrada");
        }*/
    }
}
