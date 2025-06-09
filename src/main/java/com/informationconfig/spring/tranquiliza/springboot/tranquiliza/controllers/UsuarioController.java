package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.controllers;

import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.Usuario;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Controller
    public class LoginController {

        @GetMapping("/ingresar")
        public String mostrarLogin() {
            // Devuelve el nombre del archivo HTML Thymeleaf (sin extensión)
            return "login";
        }
    }

    @GetMapping("/login")
    public String mostrarLogin(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Correo o contraseña incorrectos");
        }
        return "login";
    }

    @GetMapping("/register")
    public String mostrarRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register";
    }
    
   /*  @GetMapping("/ver_curso")
    public String mostrarCurso() {
        return "redirect:/curso"; // curso.html debe estar en /templates
    }*/

    @PostMapping("/do-register")
    public String registrarUsuario(
            @Valid @ModelAttribute("usuario") Usuario usuario,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        try {
            usuarioService.registrarUsuario(usuario);
            return "redirect:/login?registroExitoso";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
    @GetMapping("/usuarios")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.listarUsuarios()); // <-- LISTADO
        return "usuarios";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Usuario usuario) {
        usuarioService.guardarUsuario(usuario);
        return "redirect:/usuarios"; // <-- IMPORTANTE
    }

}