package com.ansaca.tallerAutomotriz.service.movimiento;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.command.MovimientoCommand;
import com.ansaca.tallerAutomotriz.entity.MovimientoEntity;
import com.ansaca.tallerAutomotriz.fabrica.MovimientoFabrica;
import com.ansaca.tallerAutomotriz.model.Movimiento;
import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;

import java.util.List;

public interface MovimientoService {
    List<MovimientoCommand> findAll();
    String registrarMovimiento(MovimientoCommand movimientoCommand);

    Movimiento registrarMovimientoFinalizado(String placa) throws BusinessException;

    List<MovimientoEntity> findAllByPlaca(String placa);
}
