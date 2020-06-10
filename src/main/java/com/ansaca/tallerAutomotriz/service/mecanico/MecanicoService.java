package com.ansaca.tallerAutomotriz.service.mecanico;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.command.MovimientoCommand;
import com.ansaca.tallerAutomotriz.entity.MecanicoEntity;

import java.util.List;

public interface MecanicoService {
    List<MecanicoCommand> findAll();

    String registrarMovimiento(MovimientoCommand movimientoCommand);
}
