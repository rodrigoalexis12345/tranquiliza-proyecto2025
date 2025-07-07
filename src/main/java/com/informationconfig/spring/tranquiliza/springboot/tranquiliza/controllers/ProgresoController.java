package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.controllers;

import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.CardProgresso;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.repository.ProgresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Controller
@RequestMapping("/progreso")
public class ProgresoController {
    
    @Autowired
    private ProgresoRepository progresoRepository;
    
    @GetMapping
    public String mostrarProgreso(Model model, Principal principal) {
        Long usuarioId = obtenerIdUsuario(principal.getName());
        CardProgresso progreso = progresoRepository.findByUsuarioId(usuarioId);
        
        if(progreso == null) {
            progreso = new CardProgresso();
            progreso.setUsuarioId(usuarioId);
            progresoRepository.save(progreso);
        }
        
        model.addAttribute("progreso", progreso);
        return "progreso";
    }
    
    @PostMapping("/actualizar")
    public String actualizarProgreso(@RequestParam Integer porcentaje, 
                                   @RequestParam String modulo,
                                   Principal principal) {
        Long usuarioId = obtenerIdUsuario(principal.getName());
        progresoRepository.actualizarProgreso(usuarioId, porcentaje);
        progresoRepository.actualizarModuloActual(usuarioId, modulo);
        return "redirect:/progreso";
    }
    
    private Long obtenerIdUsuario(String username) {
        // Implementa lógica para obtener ID de usuario
        return 1L; // Ejemplo
    }
}