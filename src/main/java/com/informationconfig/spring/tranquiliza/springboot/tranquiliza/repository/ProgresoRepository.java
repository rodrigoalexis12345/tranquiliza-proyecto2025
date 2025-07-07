package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.repository;

import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.CardProgresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProgresoRepository extends JpaRepository<CardProgresso, Long> {
    CardProgresso findByUsuarioId(Long usuarioId);
    
    @Transactional
    @Modifying
    @Query("UPDATE CardProgresso p SET p.porcentajeCompletado = :porcentaje WHERE p.usuarioId = :usuarioId")
    void actualizarProgreso(Long usuarioId, Integer porcentaje);
    
    @Transactional
    @Modifying
    @Query("UPDATE CardProgresso p SET p.moduloActual = :modulo WHERE p.usuarioId = :usuarioId")
    void actualizarModuloActual(Long usuarioId, String modulo);
}