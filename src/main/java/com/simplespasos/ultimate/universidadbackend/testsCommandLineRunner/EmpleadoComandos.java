package com.simplespasos.ultimate.universidadbackend.testsCommandLineRunner;

import com.simplespasos.ultimate.universidadbackend.models.entities.Enumeradores.TipoEmpleado;
import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import com.simplespasos.ultimate.universidadbackend.services.contratos.EmpleadoDAO;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

//@Component
public class EmpleadoComandos implements CommandLineRunner {

//    @Autowired
    private EmpleadoDAO servicio;

    @Override
    public void run(String... args) throws Exception {

        /*Direccion direccion = new Direccion("Street4", "40", "130012", "Sanjose", "1", "Bolivar");

        Empleado empleado = new Empleado(null, "Natalia", "Ardila", "12344567",
                direccion, new BigDecimal("200120"), TipoEmpleado.ADMINISTRATIVO);*/

       /* Optional<Persona> consulta = servicio.findById(7);
        Empleado empleado = null;
        if (consulta.isPresent()){
            empleado = (Empleado) consulta.get();
            empleado.setSueldo(new BigDecimal("315000"));
            empleado.setTipoEmpleado(TipoEmpleado.MANTENIMIENTO);
            servicio.save(empleado);
        }*/

        List<Persona> lista = (List<Persona>) servicio.findEmpleadoByTipoEmpleado(TipoEmpleado.ADMINISTRATIVO);

        if (lista.isEmpty()){
            System.out.println("la lista esta vacia");
        }else {
            lista.forEach(System.out::println);
        }






    }
}
