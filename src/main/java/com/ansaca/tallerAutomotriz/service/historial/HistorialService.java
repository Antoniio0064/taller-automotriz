package com.ansaca.tallerAutomotriz.service.historial;

import com.ansaca.tallerAutomotriz.command.HistorialCommand;
import com.ansaca.tallerAutomotriz.entity.HistorialEntity;

import java.util.List;

public interface HistorialService {
    List<HistorialCommand> findAll();

    HistorialEntity findById(Integer idHistorial);
}
