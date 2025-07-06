package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.Usuario;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.services.UsuarioService;

@Controller
@RequestMapping("/api/usuarios")
public class UsuarioApiController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return usuarioService.guardarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtener(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/guardar")
        public String guardar(@ModelAttribute Usuario usuario) {
        usuarioService.guardarUsuario(usuario);
        return "redirect:/usuarios"; // Redirige y refresca la lista
    }
}