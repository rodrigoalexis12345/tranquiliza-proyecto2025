package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.controllers;

import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.Usuario;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.services.UsuarioService;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Mostrar formulario de login
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";  // Se muestra la página de login (login.html)
    }

    // Mostrar formulario de registro
    @GetMapping("/register")
    public String mostrarRegistro() {
        return "register";  // Se muestra la página de registro (register.html)
    }

    // Procesar el registro de un nuevo usuario
    @PostMapping("/do-register")
    public String registrarUsuario(Usuario usuario, Model model) {
        // Verificar si el correo ya está registrado
        if (usuarioService.encontrarPorCorreo(usuario.getCorreo()).isPresent()) {
            model.addAttribute("error", "Correo ya registrado");
            return "register";  // Volver a la página de registro con el error
        }
        
        usuarioService.registrarUsuario(usuario);
        return "redirect:/login";  // Redirigir al login después de registrar
    }

    // Procesar el inicio de sesión
    @PostMapping("/do-login")
    public String loginUsuario(String correo, String contraseña, Model model) {
        Optional<Usuario> usuario = usuarioService.encontrarPorCorreo(correo);
        
        if (usuario.isPresent() && new BCryptPasswordEncoder().matches(contraseña, usuario.get().getContraseña())) {
            model.addAttribute("mensaje", "Inicio de sesión exitoso");
            return "index";  // Página principal después de iniciar sesión
        } else {
            model.addAttribute("error", "Correo o contraseña incorrectos");
            return "login";  // Mostrar error en la página de login
        }
    }
}
