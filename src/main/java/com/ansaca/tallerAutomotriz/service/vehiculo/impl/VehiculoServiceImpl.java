package com.ansaca.tallerAutomotriz.service.vehiculo.impl;

import com.ansaca.tallerAutomotriz.command.VehiculoCommand;
import com.ansaca.tallerAutomotriz.entity.VehiculoEntity;
import com.ansaca.tallerAutomotriz.fabrica.VehiculoFabrica;
import com.ansaca.tallerAutomotriz.model.businessexception.HistorialNoExisteException;
import com.ansaca.tallerAutomotriz.model.businessexception.VehiculoNoExisteException;
import com.ansaca.tallerAutomotriz.model.businessexception.VehiculoYaExisteException;
import com.ansaca.tallerAutomotriz.repository.VehiculoRepository;
import com.ansaca.tallerAutomotriz.service.historial.HistorialService;
import com.ansaca.tallerAutomotriz.service.vehiculo.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {
    private static final String VEHICULO_YA_EXISTE = "El vehiculo ya fue registrado";
    private static final String VEHICULO_REGISTRADO_EXITOSAMENTE = "El vehículo se registro exitosamente";
    private static final String HISTORIAL_NO_EXISTE = "El historial no ha sido configurado";

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private VehiculoFabrica vehiculoFabrica;

    @Autowired
    private HistorialService historialService;

    @Override
    public List<VehiculoCommand> findAll() {
        return vehiculoFabrica.entityToCommand(vehiculoRepository.findAll());
    }

    @Override
    public VehiculoEntity findByPlaca(String placa) {
        return vehiculoRepository.findByPlaca(placa);
    }

    @Override
    public String registrarVehiculo(VehiculoCommand vehiculoCommand) {
        validarNoExistaVehiculo(vehiculoCommand.getPlaca());

        VehiculoEntity vehiculoEntity = new VehiculoEntity();
        vehiculoEntity.setPlaca(vehiculoCommand.getPlaca());
        vehiculoEntity.setTipoVehiculo(vehiculoCommand.getTipoVehiculo());
        vehiculoEntity.setEstado(vehiculoCommand.getEstado());
        vehiculoRepository.save(vehiculoEntity);
        return VEHICULO_REGISTRADO_EXITOSAMENTE;
    }

    private void validarNoExistaVehiculo(String placa){
        if(vehiculoRepository.findByPlaca(placa) != null)
            throw new VehiculoYaExisteException(VEHICULO_YA_EXISTE);
    }
}
