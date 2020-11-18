package com.ansaca.tallerAutomotriz.controller;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.command.MovimientoCommand;
import com.ansaca.tallerAutomotriz.entity.MecanicoEntity;
import com.ansaca.tallerAutomotriz.model.Mecanico;
import com.ansaca.tallerAutomotriz.model.Movimiento;
import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
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


    @PostMapping("/mecanico")
    public String registrarMecanico(@RequestBody MecanicoCommand mecanicoCommand){
        return mecanicoService.registrarMecanico(mecanicoCommand);
    }

    @GetMapping("/{idMecanico}/mecanico")
    public Mecanico consultarInformacionMecanico(@PathVariable Integer idMecanico) throws BusinessException {
        return mecanicoService.consultarInformacionMecanico(idMecanico);
    }

    @DeleteMapping("/{idMecanico}/mecanico")
    public String eliminarMecanico(@PathVariable Integer idMecanico){
        return mecanicoService.eliminarMecanico(idMecanico);
    }

    @PutMapping("/mecanico/update")
    public String actualizarMecanico(@RequestBody MecanicoCommand mecanicoCommand){
        return mecanicoService.actualizarMecanico(mecanicoCommand);
    }
}
