package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.controllers;

import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.Usuario;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UsuarioRepository usuarioRepository;

 @GetMapping({"homeprincipal/", "/index"})
public String mostrarInicio(@AuthenticationPrincipal User user, Model model) {
    if (user != null) {
        String correo = user.getUsername();
        Usuario usuario = usuarioRepository.findByCorreo(correo).orElse(null);

        if (usuario != null) {
            model.addAttribute("usuarioSesion", usuario);

            // Calculamos la inicial
            String inicial = usuario.getNombre() != null && !usuario.getNombre().isEmpty()
                    ? usuario.getNombre().substring(0, 1).toUpperCase()
                    : "?";
            model.addAttribute("inicial", inicial);

            // Para el modal de bienvenida
            model.addAttribute("nombreUsuario", usuario.getNombre());
        }
    }

    return "index";
}
}
