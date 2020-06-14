package com.ansaca.tallerAutomotriz.service.propietario;

import com.ansaca.tallerAutomotriz.command.PropietarioCommand;
import com.ansaca.tallerAutomotriz.entity.PropietarioEntity;
import com.ansaca.tallerAutomotriz.model.Propietario;
import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;

import java.util.List;

public interface PropietarioService {
    List<PropietarioCommand> findAll();

    String registrarPropietario(PropietarioCommand propietarioCommand);

    Propietario consultarInformacionPropietario(String placa) throws BusinessException;
}
