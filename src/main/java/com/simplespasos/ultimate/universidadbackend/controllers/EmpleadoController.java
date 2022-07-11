package com.simplespasos.ultimate.universidadbackend.controllers;

import com.simplespasos.ultimate.universidadbackend.models.entities.Empleado;
import com.simplespasos.ultimate.universidadbackend.models.entities.Enumeradores.TipoEmpleado;
import com.simplespasos.ultimate.universidadbackend.models.entities.Pabellon;
import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import com.simplespasos.ultimate.universidadbackend.services.contratos.EmpleadoDAO;
import com.simplespasos.ultimate.universidadbackend.services.contratos.PabellonDAO;
import com.simplespasos.ultimate.universidadbackend.services.contratos.PersonaDAO;
import com.simplespasos.ultimate.universidadbackend.util.ResponseEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController extends PersonaController{

    private final PabellonDAO pabellonDAO;

    @Autowired
    public EmpleadoController(@Qualifier("empleadoDAOImp") PersonaDAO service, PabellonDAO pabellonDAO) {
        super(service);
        this.pabellonDAO = pabellonDAO;
        nombreEntidad = "empleado";
    }

    @Override
    public ResponseEntity<?> findAll() {
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();
        List<Persona> empleados = (List<Persona>) ((EmpleadoDAO) service).findAllEmpleado();

        if (empleados.isEmpty()){
            //throw new BadRequestException("No existen alumnos");
            String message = String.format("Not found %ss", nombreEntidad);

            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        result = responseEntityUtil.getResponseOk(empleados);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/tipo")
    public ResponseEntity<?> getEmpleadosByTipo(@RequestParam String tipo) {
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();
        if (!tipo.equals("MANTENIMIENTO") && !tipo.equals("ADMINISTRATIVO")) {
            //throw new BadRequestException(String.format("Invalid tipo: %s", tipo));
            String message = String.format("Invalid tipo: %s", tipo);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        List<Persona> empleados = (List<Persona>) ((EmpleadoDAO) service).findEmpleadoByTipoEmpleado(TipoEmpleado.valueOf(tipo));
        if (empleados.isEmpty()) {
            //throw new BadRequestException(String.format("Not Found tipo: %s", tipo));
            String message = String.format("Not Found tipo: %s", tipo);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        result = responseEntityUtil.getResponseOk(empleados);

        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmpleado(@PathVariable Integer id, @RequestBody Empleado empleado){
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();
        Optional<Persona> personaFound = service.findById(id);

        if (personaFound.isEmpty()) {
            //throw new BadRequestException(String.format("Empleado with id %d not found", id));
            String message = String.format("Empleado with id %d not found", id);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        Empleado empleadoFound = (Empleado) personaFound.get();

        empleadoFound.setNombre(empleado.getNombre());
        empleadoFound.setApellido(empleado.getApellido());
        empleadoFound.setDireccion(empleado.getDireccion());
        empleadoFound.setDni(empleado.getDni());
        empleadoFound.setSueldo(empleado.getSueldo());

        result = responseEntityUtil.getResponseOk(service.save(empleadoFound));
        return ResponseEntity.ok(result);
    }
    
    @PutMapping("/{idEmpleado}/pabellon/{idPabellon}")
    public ResponseEntity<?> addPabellon(@PathVariable Integer idEmpleado, @PathVariable Integer idPabellon){
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();

        Optional<Persona> empleado = service.findById(idEmpleado);
        if (empleado.isEmpty()) {
            //throw new BadRequestException(String.format("Empleado with %s not found ", idEmpleado));
            String message = String.format("Empleado with %s not found ", idEmpleado);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        Optional<Pabellon> pabellon = pabellonDAO.findById(idPabellon);
        if (pabellon.isEmpty()) {
            //throw new BadRequestException(String.format("Pabellon with %s not found", idPabellon));
            String message = String.format("Pabellon with %s not found", idPabellon);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        ((Empleado)empleado.get()).setPabellon(pabellon.get());
        result = responseEntityUtil.getResponseOk(service.save(empleado.get()));

        return ResponseEntity.ok(result);
    }
}
