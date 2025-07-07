package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.repository;

import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.CardsReels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ReelsRepository extends JpaRepository<CardsReels, Long> {
    
    // Método para buscar reels por categoría
    List<CardsReels> findByCategoria(String categoria);
    
    // Consulta personalizada para los reels más recientes
    @Query("SELECT r FROM CardsReels r ORDER BY r.fechaPublicacion DESC")
    List<CardsReels> findRecientes();
    
    // Consulta para obtener todas las categorías distintas
    @Query("SELECT DISTINCT r.categoria FROM CardsReels r")
    List<String> findAllCategorias();
}