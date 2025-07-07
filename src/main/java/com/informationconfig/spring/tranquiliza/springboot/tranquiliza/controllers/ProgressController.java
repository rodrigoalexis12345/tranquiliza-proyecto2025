package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProgressController {

    @GetMapping("/progreso")  // Cambiado a "/progreso" para coincidir con tu HTML
    public String showProgressPage() {
        return "progreso"; // Asegúrate de que el archivo se llame "progreso.html"
    }
}