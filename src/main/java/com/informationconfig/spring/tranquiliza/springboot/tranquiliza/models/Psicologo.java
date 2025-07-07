package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models;

import jakarta.persistence.*;

@Entity
@Table(name = "psicologos")
public class Psicologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especialidad;

    private String diaDisponible;
    private String horarioDisponible;
    private boolean disponible;

    // Constructor vacío (obligatorio para JPA)
    public Psicologo() {
    }

    // Constructor personalizado (para uso manual)
    public Psicologo(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    // Getters y setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getDiaDisponible() { return diaDisponible; }
    public void setDiaDisponible(String diaDisponible) { this.diaDisponible = diaDisponible; }

    public String getHorarioDisponible() { return horarioDisponible; }
    public void setHorarioDisponible(String horarioDisponible) { this.horarioDisponible = horarioDisponible; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
