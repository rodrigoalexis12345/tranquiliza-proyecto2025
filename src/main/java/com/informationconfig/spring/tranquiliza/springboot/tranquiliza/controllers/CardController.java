package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.Cards;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.repository.CardRepository;

import java.util.List;

@Controller
//@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @GetMapping("/")
    public String mostrarPaginaPrincipal(Model model) {
        List<Cards> cards = cardRepository.findAll(); // Obtener todas las tarjetas
        model.addAttribute("cards", cards);  // Pasar las tarjetas al modelo
        return "index";  // Thymeleaf buscará "index.html" en resources/templates
    }
}