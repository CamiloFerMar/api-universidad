package com.simplespasos.ultimate.universidadbackend.controllers;

import com.simplespasos.ultimate.universidadbackend.models.entities.Aula;
import com.simplespasos.ultimate.universidadbackend.models.entities.Enumeradores.Pizarron;
import com.simplespasos.ultimate.universidadbackend.models.entities.Pabellon;
import com.simplespasos.ultimate.universidadbackend.services.contratos.AulaDAO;
import com.simplespasos.ultimate.universidadbackend.services.contratos.PabellonDAO;
import com.simplespasos.ultimate.universidadbackend.util.ResponseEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/aulas")
public class AulaController extends GenericController<Aula, AulaDAO> {

    private final PabellonDAO pabellonDAO;

    @Autowired
    public AulaController(AulaDAO service, PabellonDAO pabellonDAO) {
        super(service);
        this.pabellonDAO = pabellonDAO;
    }

    @GetMapping("/numero/{numeroAula}")
    public ResponseEntity<?> getAulaByNumeroAula(@PathVariable Integer numeroAula) {
        Map<String, Object> result;
        ResponseEntityUtil responseEntity = new ResponseEntityUtil();
        Optional<Aula> aula = service.findAulaByNumeroAula(numeroAula);

        if (aula.isEmpty()) {
            //throw new BadRequestException(String.format("Aula %s not found", numeroAula));
            String message = String.format("Aula %s not found", numeroAula);

            return ResponseEntity.badRequest().body(responseEntity.getResponseBadRequest(message));
        }

        result = responseEntity.getResponseOk(aula.get());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/nombre")
    public ResponseEntity<?> getAulasByNombrePabellon(@RequestParam String nombre) {
        Map<String, Object> result;
        ResponseEntityUtil responseEntity = new ResponseEntityUtil();

        List<Aula> aulas = (List<Aula>) service.findAulasByPabellon_Nombre(nombre);
        if(aulas.isEmpty()) {
            //throw new BadRequestException(String.format("Not found aulas with name Pabellon: %s", nombre));
            String message = String.format("Not found aulas with name Pabellon: %s", nombre);

            return ResponseEntity.badRequest().body(responseEntity.getResponseBadRequest(message));
        }

        result = responseEntity.getResponseOk(aulas);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/pizarra")
    public ResponseEntity<?> getAulasByTipoPizarra(@RequestParam String pizarra){
        Map<String, Object> result;
        ResponseEntityUtil responseEntity = new ResponseEntityUtil();

        if (!pizarra.equals("PIZARRA_TIZA") && !pizarra.equals("PIZARRA_BLANCA")) {
            //throw new BadRequestException(String.format("Invalid pizarra: %s", pizarra));
            String message = String.format("Invalid pizarra: %s", pizarra);

            return ResponseEntity.badRequest().body(responseEntity.getResponseBadRequest(message));
        }

        List<Aula> aulas = (List<Aula>) service.findAulasByPizarra(Pizarron.valueOf(pizarra));
        if (aulas.isEmpty()) {
            //throw new BadRequestException(String.format("Not found pizarra: %s", pizarra));
            String message = String.format("Not found pizarra: %s", pizarra);

            return ResponseEntity.badRequest().body(responseEntity.getResponseBadRequest(message));
        }

        result = responseEntity.getResponseOk(aulas);

        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAula(@PathVariable Integer id, @RequestBody Aula aula){
        Map<String, Object> result;
        ResponseEntityUtil responseEntity = new ResponseEntityUtil();
        Optional<Aula> aulaFound = service.findById(id);
        if(aulaFound.isEmpty()) {
            //throw new BadRequestException(String.format("Aula with id %s not found", id));
            String message = String.format("Aula with id %s not found", id);

            return ResponseEntity.badRequest().body(responseEntity.getResponseBadRequest(message));
        }

        aulaFound.get().setNumeroAula(aula.getNumeroAula());
        aulaFound.get().setCantidadPupitres(aula.getCantidadPupitres());
        aulaFound.get().setPizarra(aula.getPizarra());

        result = responseEntity.getResponseOk(service.save(aulaFound.get()));

        return ResponseEntity.ok(result);
    }

    @PutMapping("/{idAula}/pabellones/{idPabellones}")
    public ResponseEntity<?> addPabellon(@PathVariable Integer idAula, @PathVariable Integer idPabellones){
        Map<String, Object> result;
        ResponseEntityUtil responseEntity = new ResponseEntityUtil();

        Optional<Aula> aula = service.findById(idAula);
        if (aula.isEmpty()) {
            //throw new BadRequestException(String.format("Aula with id %s not found", idAula));
            String message = String.format("Aula with id %s not found", idAula);
            return ResponseEntity.badRequest().body(responseEntity.getResponseBadRequest(message));
        }

        Optional<Pabellon> pabellon = pabellonDAO.findById(idPabellones);
        if (pabellon.isEmpty()) {
            //throw new BadRequestException(String.format("Pabellon with id %s not found", idPabellones));
            String message = String.format("Pabellon with id %s not found", idPabellones);
            return ResponseEntity.badRequest().body(responseEntity.getResponseBadRequest(message));
        }

        aula.get().setPabellon(pabellon.get());

        result = responseEntity.getResponseOk(service.save(aula.get()));

        return ResponseEntity.ok(result);
    }



}
