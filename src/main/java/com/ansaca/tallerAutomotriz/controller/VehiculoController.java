package com.ansaca.tallerAutomotriz.controller;

import com.ansaca.tallerAutomotriz.command.VehiculoCommand;
import com.ansaca.tallerAutomotriz.entity.VehiculoEntity;
import com.ansaca.tallerAutomotriz.model.Vehiculo;
import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import com.ansaca.tallerAutomotriz.service.vehiculo.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping("/v1/listado-vehiculos")
    public List<VehiculoCommand> findAll(){ return vehiculoService.findAll(); }


    @PostMapping("/vehiculo")
    public String registrarVehiculo (@RequestBody VehiculoCommand vehiculoCommand){
        return vehiculoService.registrarVehiculo(vehiculoCommand);
    }

    @GetMapping("/{placa}/vehiculo")
    public Vehiculo consultarInformacionVehiculo(@PathVariable String placa) throws BusinessException {
        return vehiculoService.consultarInformacionVehiculo(placa);
    }
}
