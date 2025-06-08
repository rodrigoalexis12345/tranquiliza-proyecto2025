package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.Curso;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.repository.CursoRepository;

import java.util.List;

@Controller
//@RequestMapping("/curso")
public class CursoController {
 @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("curso")
    public String listarCurso(Model model) {
        List<Curso> cursos = cursoRepository.findAll();
        model.addAttribute("cursos", cursos);
        return "curso";
    }
}
