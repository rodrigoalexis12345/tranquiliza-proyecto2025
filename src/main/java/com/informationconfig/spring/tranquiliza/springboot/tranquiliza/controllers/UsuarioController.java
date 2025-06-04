package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.controllers;

import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.Usuario;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.services.UsuarioService;

import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controlador para manejar registro e inicio de sesión.
 */
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * Muestra la página de login.
     */
    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("usuarioLogin", new Usuario());
        return "login";
    }

    /**
     * Muestra el formulario de registro y adiciona un objeto Usuario vacío.
     */
    @GetMapping("/register")
    public String mostrarRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register";
    }

    /**
     * Procesa el registro de un nuevo usuario usando @ModelAttribute para binding.
     * @param usuario objeto binding de Thymeleaf
     * @param bindingResult para validar anotaciones de entidad
     * @param model para pasar atributos a la vista
     */
    @PostMapping("/do-register")
    public String registrarUsuario(
        @Valid @ModelAttribute("usuario") Usuario usuario,
        BindingResult bindingResult,
        Model model
    ) {
        // Si hay errores de validación (ej. correo vacío, formato inválido, contraseña corta)
        if (bindingResult.hasErrors()) {
            return "register";
        }

        try {
            usuarioService.registrarUsuario(usuario);
            // Redirige con un parámetro de éxito
            return "redirect:/login?registroExitoso";
        } catch (IllegalArgumentException e) {
            // Capturamos el error personalizado desde el Service
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    /**
     * Procesa el inicio de sesión. Compara la contraseña en texto con la encriptada en BD.
     * @param usuarioLogin objeto binding para login (solo correo y contrasena)
     * @param model para pasar atributos a la vista
     */
    @PostMapping("/do-login")
    public String loginUsuario(
        @ModelAttribute("usuarioLogin") Usuario usuarioLogin,
        Model model
    ) {
        Optional<Usuario> usuarioBD = usuarioService.encontrarPorCorreo(usuarioLogin.getCorreo());

        if (usuarioBD.isPresent()) {
            // Comparamos con BCryptPasswordEncoder inyectado
            if (passwordEncoder.matches(usuarioLogin.getContrasena(), usuarioBD.get().getContrasena())) {
                // Autenticación exitosa
                return "redirect:/index"; // Redireccionar al index
            }
        }
        // Si no es exitoso, mostramos error
        model.addAttribute("error", "Correo o contraseña incorrectos");
        return "login";
    }
}
