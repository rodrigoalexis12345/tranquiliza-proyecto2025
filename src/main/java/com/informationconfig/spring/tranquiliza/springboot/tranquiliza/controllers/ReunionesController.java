package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.repository.PsicologoRepository;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.services.CitaService;

import org.springframework.ui.Model;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.Cita;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.Psicologo;


import java.util.Arrays;
import java.util.List;

@Controller
public class ReunionesController {

    // Lista local de psicólogos
    private final List<Psicologo> psicologos = Arrays.asList(
        new Psicologo("Dra. Elena Sánchez", "Ansiedad"),
        new Psicologo("Dr. Luis Ramírez", "Depresión"),
        new Psicologo("Dra. Valeria Torres", "Autoestima"),
        new Psicologo("Dr. Marco Gutiérrez", "Terapia familiar")
    );

    @GetMapping("/reuniones")
    public String mostrarFormularioReuniones(Model model) {
        model.addAttribute("psicologos", psicologos);
        return "reuniones";
    }

    @PostMapping("/detalles")
    public String verDetalles(
            @RequestParam String nombre,
            @RequestParam String especialidad,
            @RequestParam String fecha,
            @RequestParam String hora,
            Model model) {

        model.addAttribute("nombre", nombre);
        model.addAttribute("especialidad", especialidad);
        model.addAttribute("fecha", fecha);
        model.addAttribute("hora", hora);

        return "detalles";
    }
}