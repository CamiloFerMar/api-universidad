package com.simplespasos.ultimate.universidadbackend.controllers;

import com.simplespasos.ultimate.universidadbackend.models.entities.Carrera;
import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import com.simplespasos.ultimate.universidadbackend.models.entities.Profesor;
import com.simplespasos.ultimate.universidadbackend.services.contratos.CarreraDAO;
import com.simplespasos.ultimate.universidadbackend.services.contratos.PersonaDAO;
import com.simplespasos.ultimate.universidadbackend.services.contratos.ProfesorDAO;
import com.simplespasos.ultimate.universidadbackend.services.implementaciones.ProfesorDAOImp;
import com.simplespasos.ultimate.universidadbackend.util.ResponseEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/profesores")
public class ProfesorController extends PersonaController{

    private final CarreraDAO carreraDAO;

    @Autowired
    public ProfesorController(@Qualifier("profesorDAOImp") PersonaDAO service, CarreraDAO carreraDAO) {
        super(service);
        nombreEntidad = "profesor";
        this.carreraDAO = carreraDAO;
    }

    @Override
    public ResponseEntity<?> findAll() {
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();

        List<Persona> profesores = (List<Persona>) ((ProfesorDAO) service).findAllProfesores();

        if(profesores.isEmpty()){
            //throw new BadRequestException("No existen profesores");
            String message = String.format("Not found %ss", nombreEntidad);

            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }
        result = responseEntityUtil.getResponseOk(profesores);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/carrera")
    public ResponseEntity<?> getProfesoresByCarrera(@RequestParam String carrera) {

        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();
        List<Persona> profesores = (List<Persona>) ((ProfesorDAOImp) service).findProfesoresByCarrera(carrera);

        if (profesores.isEmpty()){
            //throw new BadRequestException(String.format("No hay profesores con el nombre de carrera %S", carrera));
            String message = String.format("No hay profesores con el nombre de carrera %S", carrera);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        result = responseEntityUtil.getResponseOk(profesores);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{idProfesor}/carreras/{idsCarreras}")
    public ResponseEntity<?> addCarreras (@PathVariable Integer idProfesor, @PathVariable List<Integer> idsCarreras) {
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();
        Optional<Persona> profesorFound = service.findById(idProfesor);

        if (profesorFound.isEmpty()){
            //throw new BadRequestException(String.format("profesor with id %s not found", idProfesor));
            String message = String.format("profesor with id %s not found", idProfesor);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }


        Set<Carrera> carrerasBeforeFound = ((Profesor) profesorFound.get()).getCarreras();
        Set<Carrera> carrerasAfterFound = new HashSet<>();

        if (idsCarreras.isEmpty()) {
            //throw new BadRequestException("ids Carreras is empty");
            String message = "ids Carreras is empty";
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        for (Integer id : idsCarreras){
            if (carreraDAO.findById(id).isEmpty()) {
                //throw new BadRequestException(String.format("carrere with id %s not found", id));
                String message = String.format("carrere with id %s not found", id);
                return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
            }
            carrerasAfterFound.add(carreraDAO.findById(id).get());
        }

        carrerasAfterFound.addAll(carrerasBeforeFound);

        ((Profesor)profesorFound.get()).setCarreras(new HashSet<>(carrerasAfterFound));

        result = responseEntityUtil.getResponseOk(service.save(profesorFound.get()));

        return ResponseEntity.ok(result);

    }
}
