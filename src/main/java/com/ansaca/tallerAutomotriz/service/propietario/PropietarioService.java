package com.ansaca.tallerAutomotriz.service.propietario;

import com.ansaca.tallerAutomotriz.command.PropietarioCommand;
import com.ansaca.tallerAutomotriz.entity.PropietarioEntity;

import java.util.List;

public interface PropietarioService {
    List<PropietarioCommand> findAll();
}
