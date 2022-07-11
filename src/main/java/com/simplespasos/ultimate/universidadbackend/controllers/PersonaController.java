package com.simplespasos.ultimate.universidadbackend.controllers;

import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import com.simplespasos.ultimate.universidadbackend.services.contratos.PersonaDAO;
import com.simplespasos.ultimate.universidadbackend.util.ResponseEntityUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersonaController extends GenericController <Persona, PersonaDAO> {

    public PersonaController(PersonaDAO service) {
        super(service);
    }

    @GetMapping("/nombre-apellido")
    public ResponseEntity<?> getPersonaNombreYApellido(@RequestParam String nombre, @RequestParam String apellido) {
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();
        Optional<Persona> persona = service.buscarNombreApellido(nombre, apellido);
        if (persona.isEmpty()){
            //throw new BadRequestException(String.format("%s not found", nombreEntidad));
            String message = String.format("%s not found", nombreEntidad);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        result = responseEntityUtil.getResponseOk(persona.get());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/dni")
    public ResponseEntity<?> getPersonaByDNI(@RequestParam String dni){
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();
        Optional<Persona> persona = service.buscarPorDNI(dni);
        if (persona.isEmpty()){
            //throw new BadRequestException(String.format("%s not found", nombreEntidad));
            String message = String.format("%s not found", nombreEntidad);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        result = responseEntityUtil.getResponseOk(persona.get());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/apellido")
    public ResponseEntity<?> getPersonasByApellido(@RequestParam String apellido){
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();
        List<Persona> personas = (List<Persona>) service.buscarPorApellido(apellido);
        if (personas.isEmpty()){
            //throw new BadRequestException(String.format("%ss not found", nombreEntidad));
            String message = String.format("%s not found", nombreEntidad);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        result = responseEntityUtil.getResponseOk(personas);
        return ResponseEntity.ok(result);
    }
}
