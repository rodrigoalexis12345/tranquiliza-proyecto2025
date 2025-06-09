package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.services;

import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.Usuario;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para operaciones relacionadas con Usuario.
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * Busca un usuario por su correo.
     * @param correo el correo a buscar
     * @return Optional<Usuario>
     */
    public Optional<Usuario> encontrarPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    /**
     * Registra un nuevo usuario en la base de datos.
     * Encripta la contraseña antes de persistir.
     * @param usuario objeto Usuario sin encriptar
     * @return Usuario persistido
     * @throws IllegalArgumentException si el correo ya existe
     */
    public Usuario registrarUsuario(Usuario usuario) {
        // Verificación doble: si existe, lanzamos excepción
        if (usuarioRepository.findByCorreo(usuario.getCorreo()).isPresent()) {
            throw new IllegalArgumentException("Correo ya registrado");
        }

        // Encriptar contraseña una sola vez aquí
        String passEncriptada = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(passEncriptada);

        // Guardar en la BD
        return usuarioRepository.save(usuario);
    }
     public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll(); 
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario); 
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Object listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

}
