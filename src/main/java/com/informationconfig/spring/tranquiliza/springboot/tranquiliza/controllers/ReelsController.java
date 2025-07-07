package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.controllers;

import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.CardsReels;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.repository.ReelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping("/reels")
public class ReelsController {
    
    @Autowired
    private ReelsRepository reelsRepository;
    
    @GetMapping
    public String mostrarReels(Model model, 
                             @RequestParam(required = false) String categoria) {
        List<CardsReels> reels;
        
        if(categoria != null && !categoria.isEmpty()) {
            reels = reelsRepository.findByCategoria(categoria);
        } else {
            reels = reelsRepository.findRecientes();
        }
        
        model.addAttribute("reels", reels);
        model.addAttribute("categorias", reelsRepository.findAllCategorias());
        return "reels";
    }
    
    @GetMapping("/{id}")
    public String mostrarReelDetalle(@PathVariable Long id, Model model) {
        CardsReels reel = reelsRepository.findById(id).orElseThrow();
        model.addAttribute("reel", reel);
        return "reel-detalle";
    }
}