package com.simplespasos.ultimate.universidadbackend.controllers;

import com.simplespasos.ultimate.universidadbackend.models.entities.Alumno;
import com.simplespasos.ultimate.universidadbackend.models.entities.Carrera;
import com.simplespasos.ultimate.universidadbackend.models.entities.Persona;
import com.simplespasos.ultimate.universidadbackend.services.contratos.AlumnosDAO;
import com.simplespasos.ultimate.universidadbackend.services.contratos.CarreraDAO;
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
@RequestMapping("/alumnos")
public class AlumnoController extends PersonaController{

    private final CarreraDAO carreraDAO;

    @Autowired
    public AlumnoController(@Qualifier("alumnoDAOImp") PersonaDAO alumnoDao, CarreraDAO carreraDAO) {
        super(alumnoDao);
        nombreEntidad = "Alumno";
        this.carreraDAO = carreraDAO;
    }

    @Override
    public ResponseEntity<?> findAll() {
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();
        List<Persona> alumnos = (List<Persona>) ((AlumnosDAO)service).findAllAlumno();

        if(alumnos.isEmpty()) {
            //throw new BadRequestException("No existen alumnos");
            String message = String.format("%ss not found", nombreEntidad);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        result = responseEntityUtil.getResponseOk(alumnos);

        return ResponseEntity.ok().body(result);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAlumno(@PathVariable Integer id, @RequestBody Persona alumno){
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();
        Optional<Persona> alumnoFound = service.findById(id);
        if (alumnoFound.isEmpty()){
            //throw new BadRequestException(String.format("Alumno with id %d not found", id));
            String message = String.format("Alumno with id %d not found", id);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }
        alumnoFound.get().setNombre(alumno.getNombre());
        alumnoFound.get().setApellido(alumno.getApellido());
        alumnoFound.get().setDireccion(alumno.getDireccion());
        alumnoFound.get().setDni(alumno.getDni());

        result = responseEntityUtil.getResponseOk(service.save(alumnoFound.get()));

        return ResponseEntity.ok(result);
    }

    @PutMapping("/{idAlumno}/carreras/{idCarrera}")
    public ResponseEntity<?> addCarrera(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera) {
        Map<String, Object> result;
        ResponseEntityUtil responseEntityUtil = new ResponseEntityUtil();
        Optional<Persona> alumnoFound = service.findById(idAlumno);

        if (alumnoFound.isEmpty()){
            //throw new BadRequestException(String.format("Alumno with id %d not found", idAlumno));
            String message = String.format("Alumno with id %d not found", idAlumno);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        Optional<Carrera> carreraFound = carreraDAO.findById(idCarrera);
        if (carreraFound.isEmpty()){
            //throw new BadRequestException(String.format("Carrera with id %d not found", idCarrera));
            String message = String.format("Carrera with id %d not found", idCarrera);
            return ResponseEntity.badRequest().body(responseEntityUtil.getResponseBadRequest(message));
        }

        Persona alumno = alumnoFound.get();
        Carrera carrera = carreraFound.get();

        ((Alumno)alumno).setCarrera(carrera);

        result = responseEntityUtil.getResponseOk(service.save(alumno));

        return ResponseEntity.ok().body(result);

    }
}
