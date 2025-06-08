package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.repository.CardJuegoRepository;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.Cardsjuegos;

import java.util.List;

@Controller
public class CardJuegoController {

    @Autowired
    private CardJuegoRepository cardJuegoRepository;

    @GetMapping("/juegos")
    public String mostrarJuegos(Model model) {
        List<Cardsjuegos> cards = cardJuegoRepository.findAll();
        model.addAttribute("cards", cards);
        return "juegos"; // Nombre del archivo Thymeleaf
    }
}
