package com.ansaca.tallerAutomotriz.controller;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.command.MovimientoCommand;
import com.ansaca.tallerAutomotriz.entity.MecanicoEntity;
import com.ansaca.tallerAutomotriz.service.mecanico.MecanicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mecanico")
public class MecanicoController {

    @Autowired
    private MecanicoService mecanicoService;

    @GetMapping("/v1/listado-mecanicos")
    public List<MecanicoCommand> findAll(){ return mecanicoService.findAll(); }

    @PostMapping("/movimiento")
    public String registrarMovimiento(@RequestBody MovimientoCommand movimientoCommand){
        return mecanicoService.registrarMovimiento(movimientoCommand);
    }

    @PostMapping("/mecanico")
    public String registrarMecanico(@RequestBody MecanicoCommand mecanicoCommand){
        return mecanicoService.registrarMecanico(mecanicoCommand);
    }
}
