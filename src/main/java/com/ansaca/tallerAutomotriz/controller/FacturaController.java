package com.ansaca.tallerAutomotriz.controller;

import com.ansaca.tallerAutomotriz.command.FacturaCommand;
import com.ansaca.tallerAutomotriz.entity.FacturaEntity;
import com.ansaca.tallerAutomotriz.service.factura.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/factura")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @GetMapping("/v1/listado-facturas")
    public List<FacturaCommand> findAll(){
        return facturaService.findAll();
    }
}
