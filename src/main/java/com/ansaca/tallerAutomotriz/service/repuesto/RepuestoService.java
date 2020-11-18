package com.ansaca.tallerAutomotriz.service.repuesto;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.command.RepuestoCommand;
import com.ansaca.tallerAutomotriz.entity.RepuestoEntity;
import com.ansaca.tallerAutomotriz.model.Repuesto;
import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;

import java.util.List;

public interface RepuestoService {
    RepuestoEntity findById(int idRepuesto);

    List<RepuestoCommand> findAll();

    String registrarRepuesto(RepuestoCommand repuestoCommand);

    String eliminarRepuesto(Integer id);

    String actualizarRepuesto(RepuestoCommand repuestoCommand);

    Repuesto consultarInformacionRepuesto(Integer idRepuesto) throws BusinessException;
}
