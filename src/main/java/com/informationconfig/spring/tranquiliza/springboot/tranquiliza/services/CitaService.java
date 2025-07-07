package com.informationconfig.spring.tranquiliza.springboot.tranquiliza.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.models.Cita;
import com.informationconfig.spring.tranquiliza.springboot.tranquiliza.repository.CitaRepository;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepo;

    public Cita agendarCita(Cita cita) {
        return citaRepo.save(cita);
    }
}
