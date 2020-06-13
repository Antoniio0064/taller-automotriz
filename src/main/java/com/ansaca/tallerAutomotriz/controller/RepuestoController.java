package com.ansaca.tallerAutomotriz.controller;

import com.ansaca.tallerAutomotriz.command.RepuestoCommand;
import com.ansaca.tallerAutomotriz.entity.RepuestoEntity;
import com.ansaca.tallerAutomotriz.model.Repuesto;
import com.ansaca.tallerAutomotriz.service.repuesto.RepuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/repuesto")
    public String registrarRepuesto(@RequestBody RepuestoCommand repuestoCommand){
        return repuestoService.registrarRepuesto(repuestoCommand);
    }
}
