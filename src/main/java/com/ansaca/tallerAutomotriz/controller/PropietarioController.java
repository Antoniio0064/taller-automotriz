package com.ansaca.tallerAutomotriz.controller;

import com.ansaca.tallerAutomotriz.command.PropietarioCommand;
import com.ansaca.tallerAutomotriz.entity.PropietarioEntity;
import com.ansaca.tallerAutomotriz.service.propietario.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/propietario")
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    @GetMapping("/v1/listado-propietarios")
    public List<PropietarioCommand> findAll(){ return propietarioService.findAll(); }
}
