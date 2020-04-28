package com.ansaca.tallerAutomotriz.service.repuesto;

import com.ansaca.tallerAutomotriz.command.RepuestoCommand;
import com.ansaca.tallerAutomotriz.entity.RepuestoEntity;

import java.util.List;

public interface RepuestoService {
    List<RepuestoCommand> findAll();
}
