package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.Cards;

public interface CardRepository extends JpaRepository<Cards, Long> {
}