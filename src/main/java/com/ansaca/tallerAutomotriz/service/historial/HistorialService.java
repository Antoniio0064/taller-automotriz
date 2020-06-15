package com.ansaca.tallerAutomotriz.service.historial;

import com.ansaca.tallerAutomotriz.command.HistorialCommand;
import com.ansaca.tallerAutomotriz.entity.HistorialEntity;
import com.ansaca.tallerAutomotriz.model.Movimiento;

import java.util.List;

public interface HistorialService {
    List<HistorialCommand> findAll();

    HistorialEntity findById(Integer idHistorial);

    List<Movimiento> consultarHistorialVehiculo(String placa);

    void save(HistorialEntity historialEntity);
}
