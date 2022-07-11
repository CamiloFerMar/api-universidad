package com.simplespasos.ultimate.universidadbackend.controllers;

import com.simplespasos.ultimate.universidadbackend.exception.BadRequestException;
import com.simplespasos.ultimate.universidadbackend.models.entities.Pabellon;
import com.simplespasos.ultimate.universidadbackend.services.contratos.PabellonDAO;
import com.simplespasos.ultimate.universidadbackend.util.ResponseEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/pabellones")
public class PabellonController extends GenericController<Pabellon, PabellonDAO> {

    @Autowired
    public PabellonController(PabellonDAO service) {
        super(service);
        nombreEntidad = "pabellon";
    }

    @GetMapping("/localidad")
    public ResponseEntity<?> getPabellonsByDireccion_Localidad(@RequestParam String localidad){
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();

        List<Pabellon> pabellones = (List<Pabellon>) service.findPabellonsByDireccion_LocalidadIgnoreCase(localidad);

        if(pabellones.isEmpty()) {
            //throw new BadRequestException(String.format("Not found localidad: %s", localidad));
            String message = String.format("Not found localidad: %s", localidad);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        result = responseEntityUtil.getResponseOk(pabellones);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/nombre")
    public ResponseEntity<?> findPabellonsByNombreContains(@RequestParam String nombre){
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();
        List<Pabellon> pabellons = (List<Pabellon>) service.findPabellonsByNombreContainsIgnoreCase(nombre);

        if(pabellons.isEmpty()) {
            //throw new BadRequestException(String.format("Not found nombre: %s", nombre));
            String message = String.format("%s Not found nombre: %s", nombreEntidad, nombre);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }
        result = responseEntityUtil.getResponseOk(pabellons);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePabellon(@PathVariable Integer id, @RequestBody Pabellon pabellon){
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();
        Optional<Pabellon> pabellonFound = service.findById(id);
        if (pabellonFound.isEmpty()) {
            //throw new BadRequestException(String.format("Pabellon with %s not found", id));
            String message = String.format("Pabellon with %s not found", id);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        pabellonFound.get().setMts2(pabellon.getMts2());
        pabellonFound.get().setNombre(pabellon.getNombre());
        pabellonFound.get().setDireccion(pabellon.getDireccion());

        result = responseEntityUtil.getResponseOk(service.save(pabellonFound.get()));

        return ResponseEntity.ok(result);
    }

}
