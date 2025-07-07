package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.controllers;

import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.Usuario;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

@ControllerAdvice
public class GlobalModelAdvice {

    @Autowired
    private UsuarioService usuarioService;

    @ModelAttribute
    public void agregarUsuarioLogueado(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated() && !auth.getPrincipal().equals("anonymousUser")) {
            String correo = auth.getName();
            Usuario usuario = usuarioService.buscarPorCorreo(correo);
            if (usuario != null) {
                model.addAttribute("usuarioSesion", usuario);
                model.addAttribute("inicial", usuario.getNombre().substring(0, 1).toUpperCase());
            }
        }
    }
}
