package com.ansaca.tallerAutomotriz.service.mecanico;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.command.MovimientoCommand;
import com.ansaca.tallerAutomotriz.command.PersonaCommand;
import com.ansaca.tallerAutomotriz.entity.MecanicoEntity;
import com.ansaca.tallerAutomotriz.model.Mecanico;
import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;

import java.util.List;

public interface MecanicoService {
    List<MecanicoCommand> findAll();

    String registrarMovimiento(MovimientoCommand movimientoCommand);

    String registrarMecanico(MecanicoCommand mecanicoCommand);

    String eliminarMecanico(Integer id);

    String actualizarMecanico(MecanicoCommand mecanicoCommand);

    Mecanico consultarInformacionMecanico(Integer idPersona) throws BusinessException;
}
