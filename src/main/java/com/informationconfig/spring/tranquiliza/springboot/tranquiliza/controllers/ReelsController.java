package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class ReelsController {

    @GetMapping("/reels")
    public String showReels(
        Model model,
        @RequestParam(defaultValue = "") String search) {
        
        // Datos dinámicos
        model.addAttribute("navItems", List.of(
            new NavItem("Home", true),
            new NavItem("progreso", false),
            new NavItem("Calificación", false),
            new NavItem("Contacto", false),
            new NavItem("Cursos", false)
        ));

        model.addAttribute("contentText", 
            "La salud mental incluye nuestro bienestar emocional, psicológico y social...");

        model.addAttribute("stats", List.of(
            new Stat("302.9K", "Visualizaciones", "eye"),
            new Stat("612", "Comentarios", "comment"),
            new Stat("33K", "Likes", "heart"),
            new Stat("22.7K", "Compartidos", "share")
        ));

        model.addAttribute("searchQuery", search);

        return "reels";
    }

    // Records para estructura de datos
    public record NavItem(String name, boolean isActive) {}
    public record Stat(String value, String label, String icon) {}
}