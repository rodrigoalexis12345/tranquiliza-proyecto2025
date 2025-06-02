package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig {

    // Define el bean de BCryptPasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Spring creará este bean cuando sea necesario
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Configuración de las rutas permitidas sin autenticación usando la nueva sintaxis
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/", "/home", "/css/**", "/js/**", "/img/**", "/resources/**", "/mdbootstrap/**", "/login", "/register")
                    .permitAll()  // Permitir acceso sin autenticación a estas rutas
                    .anyRequest().authenticated()  // Requiere autenticación para el resto de las rutas
            )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/login")  // Página personalizada para el login
                    .permitAll()  // Permitir el acceso al formulario de login sin autenticación
            )
            .logout(logout ->
                logout.permitAll()  // Permitir el acceso al logout sin autenticación
            );

        return http.build();  // Crear y devolver el filtro de seguridad
    }
}
