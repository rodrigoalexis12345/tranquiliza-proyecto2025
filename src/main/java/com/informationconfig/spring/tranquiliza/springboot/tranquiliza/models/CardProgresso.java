package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "progreso_usuario")
public class CardProgresso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "id_usuario", nullable = false)
    private Long usuarioId;
    
    @Column(name = "porcentaje_completado")
    private Integer porcentajeCompletado = 0;
    
    @Column(name = "modulo_actual")
    private String moduloActual = "Inicio";
    
    @Column(name = "ultima_actualizacion")
    private LocalDate ultimaActualizacion = LocalDate.now();
    
    // Getters y Setters
    public Long getId() { return id; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Integer getPorcentajeCompletado() { return porcentajeCompletado; }
    public void setPorcentajeCompletado(Integer porcentajeCompletado) { 
        this.porcentajeCompletado = porcentajeCompletado; 
        this.ultimaActualizacion = LocalDate.now();
    }
    public String getModuloActual() { return moduloActual; }
    public void setModuloActual(String moduloActual) { this.moduloActual = moduloActual; }
    public LocalDate getUltimaActualizacion() { return ultimaActualizacion; }
}