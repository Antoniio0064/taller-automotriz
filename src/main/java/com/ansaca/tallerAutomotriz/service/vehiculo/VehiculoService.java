package com.ansaca.tallerAutomotriz.service.vehiculo;

import com.ansaca.tallerAutomotriz.command.VehiculoCommand;
import com.ansaca.tallerAutomotriz.entity.VehiculoEntity;

import java.util.List;

public interface VehiculoService {
    List<VehiculoCommand> findAll();
}
