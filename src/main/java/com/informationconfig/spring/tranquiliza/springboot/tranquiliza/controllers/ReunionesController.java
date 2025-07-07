package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.repository.PsicologoRepository;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.services.CitaService;

import org.springframework.ui.Model;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.Cita;

@Controller
public class ReunionesController {

    @Autowired
    private PsicologoRepository psicologoRepo;

    @Autowired
    private CitaService citaService;

    @GetMapping("/reuniones")
    public String verReuniones(Model model) {
        model.addAttribute("psicologos", psicologoRepo.findAll());
        return "reuniones";
    }

    @PostMapping("/detalles")
    public String verDetalles(@RequestParam String nombre, @RequestParam String especialidad,
                              @RequestParam String fecha, @RequestParam String hora,
                              Model model) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("especialidad", especialidad);
        model.addAttribute("fecha", fecha);
        model.addAttribute("hora", hora);
        return "detalles";
    }

    @PostMapping("/confirmar")
    public String confirmarCita(@RequestParam String nombre, @RequestParam String especialidad,
                                @RequestParam String fecha, @RequestParam String hora,
                                @RequestParam String correo, Model model) {
        Cita cita = new Cita();
        cita.setNombrePsicologo(nombre);
        cita.setEspecialidad(especialidad);
        cita.setFecha(fecha);
        cita.setHora(hora);
        cita.setCorreoUsuario(correo);
        citaService.agendarCita(cita);

        model.addAttribute("mensaje", "🎉 ¡Gracias por registrar tu cita! En breve recibirás un correo con el enlace para acceder a tu sesión online. ¡Te esperamos con gusto!");
        return "popup";
    }
}
