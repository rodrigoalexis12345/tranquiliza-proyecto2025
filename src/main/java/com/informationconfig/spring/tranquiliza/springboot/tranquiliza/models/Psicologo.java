package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

    @Entity
public class Psicologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private String especialidad;
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    private String diaDisponible;
    public String getDiaDisponible() {
        return diaDisponible;
    }
    public void setDiaDisponible(String diaDisponible) {
        this.diaDisponible = diaDisponible;
    }
    private String horario;
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    private boolean disponible;
    // Getters y Setters
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

