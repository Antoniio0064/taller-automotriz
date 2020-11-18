package com.ansaca.tallerAutomotriz.service.vehiculo;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.command.VehiculoCommand;
import com.ansaca.tallerAutomotriz.entity.VehiculoEntity;
import com.ansaca.tallerAutomotriz.model.Vehiculo;
import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;

import java.util.List;

public interface VehiculoService {
    List<VehiculoCommand> findAll();

    VehiculoEntity findByPlaca(String placa);

    String registrarVehiculo(VehiculoCommand vehiculoCommand);

    String eliminarVehiculo(Integer id);

    String actualizarVehiculo(VehiculoCommand vehiculoCommand);

    Vehiculo consultarInformacionVehiculo(String placa) throws BusinessException;
}
