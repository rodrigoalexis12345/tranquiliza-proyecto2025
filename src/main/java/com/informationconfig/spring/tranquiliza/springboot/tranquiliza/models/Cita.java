package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombrePsicologo; 
    public String getNombrePsicologo() {
        return nombrePsicologo;
    }
    public void setNombrePsicologo(String nombrePsicologo) {
        this.nombrePsicologo = nombrePsicologo;
    }
    private String especialidad;
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    private String fecha;
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    private String hora;
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    private String modalidad = "Online";
    public String getModalidad() {
        return modalidad;
    }
    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }
    private String correoUsuario; // Para enviar la confirmación
    // Getters y Setters
    public String getCorreoUsuario() {
        return correoUsuario;
    }
    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }
}
