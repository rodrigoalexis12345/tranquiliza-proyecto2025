package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.controllers;

import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.Psicologo;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.repository.PsicologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PsicologoController {

    @Autowired
    private PsicologoRepository psicologoRepository;

    @GetMapping("/psicologos")
    public List<Psicologo> listarPsicologos() {
        return psicologoRepository.findAll();
    }
}
