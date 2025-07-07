package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reels")
public class CardsReels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String titulo;
    
    @Column(nullable = false)
    private String urlVideo;
    
    @Column(nullable = false)
    private String categoria;
    
    @Column(name = "fecha_publicacion")
    private LocalDateTime fechaPublicacion = LocalDateTime.now();
    
    @Column(name = "duracion_segundos")
    private Integer duracionSegundos;
    
    // Getters y Setters
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getUrlVideo() { return urlVideo; }
    public void setUrlVideo(String urlVideo) { this.urlVideo = urlVideo; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public LocalDateTime getFechaPublicacion() { return fechaPublicacion; }
    public Integer getDuracionSegundos() { return duracionSegundos; }
    public void setDuracionSegundos(Integer duracionSegundos) { 
        this.duracionSegundos = duracionSegundos; 
    }
}