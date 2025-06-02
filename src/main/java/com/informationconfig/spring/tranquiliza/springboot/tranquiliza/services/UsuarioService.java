package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.services;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.repository.UsuarioRepository;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Registrar usuario
    public void registrarUsuario(Usuario usuario) {
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        usuarioRepository.save(usuario);
    }

    // Verificar si el usuario existe
    public Optional<Usuario> encontrarPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }
}
