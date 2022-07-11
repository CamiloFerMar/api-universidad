package com.simplespasos.ultimate.universidadbackend.controllers;

import com.simplespasos.ultimate.universidadbackend.models.entities.Carrera;
import com.simplespasos.ultimate.universidadbackend.services.contratos.CarreraDAO;
import com.simplespasos.ultimate.universidadbackend.util.ResponseEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController extends GenericController<Carrera, CarreraDAO>{


    @Autowired
    public CarreraController(CarreraDAO service) {
        super(service);
        nombreEntidad = "Carrera";
    }

    @GetMapping("/nombre-apellido")
    public ResponseEntity<?> findCarrerasByProfesor_nombreAndApellido(@RequestParam String nombre, @RequestParam String apellido) {
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();

        if (nombre.isEmpty() || apellido.isEmpty()) {
            String message = String.format("%s or %s is empty", nombre, apellido);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        List<Carrera> carreras = (List<Carrera>) service.buscarCarreraPorProfesorNombreYApellido(nombre, apellido);

        if (carreras.isEmpty()) {
            String message = String.format("%s not found by profesor: %s %s", nombreEntidad, nombre, apellido);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        result = responseEntityUtil.getResponseOk(carreras);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/nombre")
    public ResponseEntity<?> findCarrerasByNameContains(@RequestParam String nombre){
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();

        if (nombre.isEmpty()) {
            String message = String.format("%s is empty", nombre);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }
        List<Carrera> carreras = (List<Carrera>) service.findCarrerasByNombreContainsIgnoreCase(nombre);
        if (carreras.isEmpty()) {
            String message = String.format("%ss not found with nombre %s", nombreEntidad,  nombre);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        result = responseEntityUtil.getResponseOk(carreras);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/cantidadAnios")
    public ResponseEntity<?> findCarrerasByCantidadAnionAfter(@RequestParam Integer cantidad){
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();
        if (cantidad < 0){
            String message = "negative numbers are not accepted";
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        List<Carrera> carreras = (List<Carrera>) service.findCarrerasByCantidadAniosAfter(cantidad);
        if (carreras.isEmpty()){
            String message = String.format("%s not found", nombreEntidad);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        result = responseEntityUtil.getResponseOk(carreras);

        return ResponseEntity.ok(result);

    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateCarrera(@PathVariable Integer id, @RequestBody Carrera carrera) {
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();
        Optional<Carrera> carreraFound = service.findById(id);
        if (carreraFound.isEmpty()){
            //throw new BadRequestException(String.format("Carrera with id %d not found", id));
            String message = String.format("%s with id %d not found", nombreEntidad, id);

            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }
        carreraFound.get().setNombre(carrera.getNombre());
        carreraFound.get().setCantidadAnios(carrera.getCantidadAnios());
        carreraFound.get().setCantidadMaterias(carrera.getCantidadMaterias());

        result = responseEntityUtil.getResponseOk(service.save(carreraFound.get()));
        return ResponseEntity.ok(result);
    }

}
