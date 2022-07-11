package com.simplespasos.ultimate.universidadbackend.controllers;
import com.simplespasos.ultimate.universidadbackend.models.entities.Carrera;
import com.simplespasos.ultimate.universidadbackend.services.contratos.GenericDAO;
import com.simplespasos.ultimate.universidadbackend.util.ResponseEntityUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GenericController <E, S extends GenericDAO<E>>{

    protected final S service;
    protected String nombreEntidad;

    public GenericController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();
        List<E> list = (List<E>) service.findAll();

        if (list.isEmpty()){
            //throw new BadRequestException(String.format("No hay %ss", nombreEntidad));
            String message = String.format("Not found %ss", nombreEntidad);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }
        result = responseEntityUtil.getResponseOk(list);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();
        Optional<E> byId = service.findById(id);
        if (byId.isEmpty()){
            //throw new BadRequestException();
            String message = String.format("%s with id %s not found", nombreEntidad, id);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }
        result = responseEntityUtil.getResponseOk(byId.get());

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody E entity) {
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();

        if (entity instanceof Carrera){
            if (((Carrera) entity).getCantidadAnios() < 0 || ((Carrera) entity).getCantidadMaterias() < 0){
                //throw new BadRequestException("No se admiten numero negativos");
                String message = "No se admiten numeros negativos";
                return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
            }
        }

        result = responseEntityUtil.getResponseOk(service.save(entity));

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();

        service.deleteById(id);

        result.put("success", Boolean.TRUE);

        return ResponseEntity.ok(result);

    }
}
