package com.ansaca.tallerAutomotriz.service.repuesto.impl;

import com.ansaca.tallerAutomotriz.command.RepuestoCommand;
import com.ansaca.tallerAutomotriz.entity.RepuestoEntity;
import com.ansaca.tallerAutomotriz.fabrica.RepuestoFabrica;
import com.ansaca.tallerAutomotriz.model.businessexception.RepuestoYaExisteException;
import com.ansaca.tallerAutomotriz.repository.RepuestoRepository;
import com.ansaca.tallerAutomotriz.service.repuesto.RepuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepuestoServiceImpl implements RepuestoService {

    private static final String REPUESTO_YA_EXISTE = "El repuesto ya se encuentra en el sistema deberia actualizar su cantidad" +
            " y no crear otro igual";
    private static final String REPUESTO_CREADO_EXITOSAMENTE = "El Repuesto se ha registrado exitosamente";

    @Autowired
    private RepuestoRepository repuestoRepository;

    @Autowired
    private RepuestoFabrica repuestoFabrica;

    @Override
    public RepuestoEntity findById(int idRepuesto) {
        return repuestoRepository.findById(idRepuesto).orElse(null);
    }

    @Override
    public List<RepuestoCommand> findAll() {
        return repuestoFabrica.entityToCommand(repuestoRepository.findAll());
    }

    @Override
    public String registrarRepuesto(RepuestoCommand repuestoCommand) {
        validarNoExistenciaRepuesto(repuestoCommand);

        RepuestoEntity repuestoEntity = commandToEntity(repuestoCommand);
        repuestoRepository.save(repuestoEntity);
        return REPUESTO_CREADO_EXITOSAMENTE;
    }

    private void validarNoExistenciaRepuesto(RepuestoCommand repuestoCommand) {
        if(repuestoRepository.findByNombre(repuestoCommand.getNombre()) != null){
            throw new RepuestoYaExisteException(REPUESTO_YA_EXISTE);
        }
    }

    private RepuestoEntity commandToEntity(RepuestoCommand repuestoCommand){
        RepuestoEntity repuestoEntity = new RepuestoEntity();
        repuestoEntity.setNombre(repuestoCommand.getNombre());
        repuestoEntity.setDescripcion(repuestoCommand.getDescripcion());
        repuestoEntity.setCantidad(repuestoCommand.getCantidad());
        repuestoEntity.setValor(repuestoCommand.getValor());

        return repuestoEntity;
    }
}
