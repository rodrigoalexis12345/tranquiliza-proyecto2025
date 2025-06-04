package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuración de seguridad con Spring Security.
 */
@Configuration
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Desactivar CSRF para simplificar el ejemplo
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/", "/index", "/home",
                    "/css/**", "/js/**", "/img/**", "/resources/**", "/mdbootstrap/**",
                    "/login", "/register", "/do-register", "/do-login"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/do-login")    // La URL donde Thymeleaf envía el formulario
                .defaultSuccessUrl("/index", true)  // Redirigir a /index tras login exitoso
                .failureUrl("/login?error=true")    // Si falla, agregamos ?error al login
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .permitAll()
            );

        return http.build();
    }
}
