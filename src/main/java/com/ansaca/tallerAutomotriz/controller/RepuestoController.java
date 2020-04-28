package com.ansaca.tallerAutomotriz.controller;

import com.ansaca.tallerAutomotriz.command.RepuestoCommand;
import com.ansaca.tallerAutomotriz.entity.RepuestoEntity;
import com.ansaca.tallerAutomotriz.service.repuesto.RepuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/repuesto")
public class RepuestoController {

    @Autowired
    private RepuestoService repuestoService;

    @GetMapping("/v1/listado-repuestos")
    public List<RepuestoCommand> findAll(){
        return repuestoService.findAll();
    }
}
