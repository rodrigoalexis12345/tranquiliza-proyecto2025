package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
}
