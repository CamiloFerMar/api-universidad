package com.simplespasos.ultimate.universidadbackend.datos;

import com.simplespasos.ultimate.universidadbackend.models.entities.*;
import com.simplespasos.ultimate.universidadbackend.models.entities.Enumeradores.Pizarron;

import java.math.BigDecimal;

import static com.simplespasos.ultimate.universidadbackend.models.entities.Enumeradores.TipoEmpleado.*;

public class DatosDummy {

    public static Carrera carrera(boolean conId){
        return conId ? new Carrera(1, "Ingenieria en sistema", 50, 5)
                : new Carrera(null, "Ingenieria en sistema", 50, 5);
    }
    public static Carrera carrera2(){
        return new Carrera(null, "Licenciatura en sistema", 45, 4);
    }
    public static Carrera carrera3(boolean conId){
        return conId ? new Carrera(3, "Ingenieria Industrial", 50, 5)
                : new Carrera(null, "Ingenieria Industrial", 50, 5);
    }
    public static Carrera carrera4(){
        return new Carrera(null, "Licenciatura Infustrial", 45, 4);
    }

    public static Persona empleado(){
        return new Empleado(null, "Andre", "Torres", "122335456", new Direccion(), new BigDecimal("50000.87"), ADMINISTRATIVO);
    }
    public static Persona empleado2(){
        return new Empleado(null, "Kami", "De la hoz", "12975456", new Direccion(), new BigDecimal("750000.87"), MANTENIMIENTO);
    }

    public static Profesor profesor(boolean conId){
        return conId ? new Profesor(1, "Fredy", "Fernandez", "24587998", new Direccion(), new BigDecimal("60000.00"))
        : new Profesor(null, "Fredy", "Fernandez", "24587998", new Direccion(), new BigDecimal("60000.00"));
    }
    public static Profesor profesor2(){
        return new Profesor(null, "Junior", "Fernandez", "245879438", new Direccion(), new BigDecimal("65000.00"));
    }
    public static Profesor profesor3(){
        return new Profesor(null, "Andres", "Torres", "2452369438", new Direccion(), new BigDecimal("65000.00"));
    }

    public static Persona alumno(){
        return new Alumno(null, "Nill", "Alcazar", "12234565", new Direccion());
    }
    public static Persona alumno2(){
        return new Alumno(null, "Nat", "Ardila", "12234567", new Direccion());
    }
    public static Persona alumno3(){
        return new Alumno(null, "Angie", "Estrada", "12234534", new Direccion());
    }
    public static Persona alumno4(){
        return new Alumno(null, "Juan", "Ardila", "126579334", new Direccion());
    }

    public static Aula aula(boolean conId){
        return conId ? new Aula(3, 103, "45x56mt", 25, Pizarron.PIZARRA_TIZA) :
                new Aula(null, 103, "45x56mt", 25, Pizarron.PIZARRA_TIZA);
    }
    public static Aula aula2(){
        return new Aula(null, 106, "45x59mt", 25, Pizarron.PIZARRA_BLANCA);
    }

    public static Pabellon pabellon(boolean conId) {
        return conId ? new Pabellon(3, 200d, "Las aguilas", new Direccion("Cr100", "#38-75", "130010", "bolivar", "2", "3")) :
                new Pabellon(null, 200d, "Las aguilas", new Direccion("Cr100", "#38-75", "130010", "bolivar", "2", "3"));
    }

    public static Pabellon pabellon2(){
        return new Pabellon(null, 150d, "Las gardenias", new Direccion("Cr100", "#38-75", "130010", "bolivar", "2", "3"));
    }
}
