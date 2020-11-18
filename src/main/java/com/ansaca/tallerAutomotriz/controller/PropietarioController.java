package com.ansaca.tallerAutomotriz.controller;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.command.PropietarioCommand;
import com.ansaca.tallerAutomotriz.entity.PropietarioEntity;
import com.ansaca.tallerAutomotriz.model.Propietario;
import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import com.ansaca.tallerAutomotriz.service.propietario.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/propietario")
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    @GetMapping("/v1/listado-propietarios")
    public List<PropietarioCommand> findAll(){ return propietarioService.findAll(); }

    @PostMapping("/propietario")
    public String registrarPropietario(@RequestBody PropietarioCommand propietarioCommand){
        return propietarioService.registrarPropietario(propietarioCommand);
    }

    @GetMapping("/{placa}/propietario")
    public Propietario consultarInformacionPropietario(@PathVariable String placa) throws BusinessException {
        return propietarioService.consultarInformacionPropietario(placa);
    }

    @DeleteMapping("/{idPropietario}/propietario")
    public String eliminarPropietario(@PathVariable Integer idPropietario){
        return propietarioService.eliminarPropietario(idPropietario);
    }

    @PutMapping("/propietario/update")
    public String actualizarPropietario(@RequestBody PropietarioCommand propietarioCommand){
        return propietarioService.actualizarPropietario(propietarioCommand);
    }
}
