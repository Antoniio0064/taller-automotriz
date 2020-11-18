package com.ansaca.tallerAutomotriz.service.repuesto.impl;

import com.ansaca.tallerAutomotriz.command.RepuestoCommand;
import com.ansaca.tallerAutomotriz.entity.RepuestoEntity;
import com.ansaca.tallerAutomotriz.fabrica.RepuestoFabrica;
import com.ansaca.tallerAutomotriz.model.Repuesto;
import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import com.ansaca.tallerAutomotriz.model.businessexception.RepuestoNoExisteException;
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
    private static final String REPUESTO_NO_EXISTE = "El repuesto que desea consultar no existe";

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

    @Override
    public String eliminarRepuesto(Integer id) {
        if(repuestoRepository.findById(id) != null){
            repuestoRepository.deleteById(id);
            return "Eliminado Exitosamente";
        }
        return "El mecanico que intenta eliminar no existe!";
    }

    @Override
    public String actualizarRepuesto(RepuestoCommand repuestoCommand) {

        RepuestoEntity repuestoEntity = findById(repuestoCommand.getIdRepuesto());
        repuestoEntity.setNombre(repuestoCommand.getNombre());
        repuestoEntity.setValor(repuestoCommand.getValor());
        repuestoEntity.setDescripcion(repuestoCommand.getDescripcion());
        repuestoEntity.setCantidad(repuestoCommand.getCantidad());
        repuestoRepository.save(repuestoEntity);
        return "Actualizacion Exitosa";
    }

    @Override
    public Repuesto consultarInformacionRepuesto(Integer idRepuesto) throws BusinessException {
        RepuestoEntity repuestoEntity = repuestoRepository.findById(idRepuesto).orElse(null);
        validarExistenciaRepuesto(repuestoEntity);
        return repuestoFabrica.entityToModel(repuestoEntity);
    }

    private void validarExistenciaRepuesto(RepuestoEntity repuestoEntity) {
        if(repuestoEntity == null)
            throw new RepuestoNoExisteException(REPUESTO_NO_EXISTE);
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
