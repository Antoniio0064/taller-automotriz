package com.ansaca.tallerAutomotriz.controller;

import com.ansaca.tallerAutomotriz.command.HistorialCommand;
import com.ansaca.tallerAutomotriz.entity.HistorialEntity;
import com.ansaca.tallerAutomotriz.service.historial.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/historial")
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    @GetMapping("/v1/consulta-historial")
    public List<HistorialCommand> findAll(){ return historialService.findAll(); }
}
