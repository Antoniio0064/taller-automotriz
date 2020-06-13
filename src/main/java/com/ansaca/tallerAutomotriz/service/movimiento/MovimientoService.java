package com.ansaca.tallerAutomotriz.service.movimiento;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.command.MovimientoCommand;
import com.ansaca.tallerAutomotriz.entity.MovimientoEntity;
import com.ansaca.tallerAutomotriz.fabrica.MovimientoFabrica;

import java.util.List;

public interface MovimientoService {
    List<MovimientoCommand> findAll();
    String registrarMovimiento(MovimientoCommand movimientoCommand);
}
