package com.simplespasos.ultimate.universidadbackend;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class Index {

    @GetMapping("/")
    public ResponseEntity<?> getRoutes(@RequestHeader HttpHeaders headers){
        InetSocketAddress host = headers.getHost();

        assert host != null;
        String url = "http://" + host.getHostName() + ":" + host.getPort();
        String alumnosRoute = url + "/alumnos";
        String aulasRoute = url + "/aulas";
        String carrerasRoute = url + "/carreras";
        String empleadosRoute = url + "/empleados";
        String pabellonesRoute = url + "/pabellones";
        String profesoresRoute = url + "/profesores";

        Map<String, String> routes = new HashMap<>();
        routes.put("alumnos", alumnosRoute);
        routes.put("aulas", aulasRoute);
        routes.put("carreras", carrerasRoute);
        routes.put("empleados", empleadosRoute);
        routes.put("pabellones", pabellonesRoute);
        routes.put("profesores", profesoresRoute);

        return ResponseEntity.ok(routes);
    }
}
