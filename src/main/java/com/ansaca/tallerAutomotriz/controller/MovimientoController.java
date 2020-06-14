package com.ansaca.tallerAutomotriz.controller;

import com.ansaca.tallerAutomotriz.command.MovimientoCommand;
import com.ansaca.tallerAutomotriz.entity.MovimientoEntity;
import com.ansaca.tallerAutomotriz.model.Movimiento;
import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import com.ansaca.tallerAutomotriz.service.movimiento.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimiento")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping("/v1/listado-movimientos")
    public List<MovimientoCommand> findAll(){ return movimientoService.findAll(); }

    @PostMapping("/movimiento")
    public String registrarMovimiento(@RequestBody MovimientoCommand movimientoCommand){
        return movimientoService.registrarMovimiento(movimientoCommand);
    }

    @GetMapping("/{placa}/movimiento")
    public Movimiento registrarMovimientoFinalizado(@PathVariable String placa) throws BusinessException {
        return movimientoService.registrarMovimientoFinalizado(placa);
    }

}
