package com.ansaca.tallerAutomotriz.service.mecanico.impl;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.command.MovimientoCommand;
import com.ansaca.tallerAutomotriz.entity.MecanicoEntity;
import com.ansaca.tallerAutomotriz.entity.PersonaEntity;
import com.ansaca.tallerAutomotriz.fabrica.MecanicoFabrica;
import com.ansaca.tallerAutomotriz.model.Mecanico;
import com.ansaca.tallerAutomotriz.model.businessexception.*;
import com.ansaca.tallerAutomotriz.repository.MecanicoRepository;
import com.ansaca.tallerAutomotriz.repository.MovimientoRepository;
import com.ansaca.tallerAutomotriz.service.mecanico.MecanicoService;
import com.ansaca.tallerAutomotriz.service.movimiento.MovimientoService;
import com.ansaca.tallerAutomotriz.service.persona.PersonaService;
import com.ansaca.tallerAutomotriz.service.vehiculo.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MecanicoServiceImpl implements MecanicoService {

    private static final String MECANICO_CREADO_EXITOSAMENTE = "El mecanico ha sido creado exitosamente";
    private static final String PERSONA_NO_ENCONTRADO = "La persona especificado no se encuentra en el sistema, verifique" +
            "la información o registre la persona antes de darle un rol";
    private static final String MECANICO_YA_REGISTRADO = "El mecanico que intenta crear ya tiene ese rol en el sistema";
    private static final String MECANICO_NO_EXISTE = "El mecanico que intenta consultar no existe";
    private static final String ELIMINADO_EXITOSAMENTE = "Eliminacion exitosa";

    @Autowired
    private MecanicoRepository mecanicoRepository;

    @Autowired
    private MecanicoFabrica mecanicoFabrica;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private MovimientoService movimientoService;

    @Autowired
    private VehiculoService vehiculoService;

    @Override
    public List<MecanicoCommand> findAll() {
        return mecanicoFabrica.entityToCommand(mecanicoRepository.findAll());
    }

    @Override
    public String registrarMovimiento(MovimientoCommand movimientoCommand) {
        String estado = movimientoService.registrarMovimiento(movimientoCommand);
        return estado;
    }

    @Override
    public String registrarMecanico(MecanicoCommand mecanicoCommand) {
        validarExistenciaPersona(mecanicoCommand.getIdPersona());
        validarNoExistaMecanico(mecanicoCommand);

        MecanicoEntity mecanicoEntity = new MecanicoEntity();
        mecanicoEntity.setEspecialidad(mecanicoCommand.getEspecialidad());
        mecanicoEntity.setDisponibilidad(mecanicoCommand.getDisponibilidad());
        mecanicoEntity.setIdPersona(mecanicoCommand.getIdPersona());
        mecanicoRepository.save(mecanicoEntity);
        return MECANICO_CREADO_EXITOSAMENTE;
    }

    @Override
    public String eliminarMecanico(Integer id) {
        if(mecanicoRepository.findByIdPersona(id) != null){
            mecanicoRepository.deleteById(id);
            return ELIMINADO_EXITOSAMENTE;
        }
        return "El mecanico que intenta eliminar no existe!";
    }

    @Override
    public String actualizarMecanico(MecanicoCommand mecanicoCommand) {
        validarExistenciaPersona(mecanicoCommand.getIdPersona());

        MecanicoEntity mecanicoEntity = mecanicoRepository.findByIdMecanico(mecanicoCommand.getIdMecanico());
        mecanicoEntity.setEspecialidad(mecanicoCommand.getEspecialidad());
        mecanicoEntity.setDisponibilidad(mecanicoCommand.getDisponibilidad());
        mecanicoEntity.setIdPersona(mecanicoCommand.getIdPersona());
        mecanicoRepository.save(mecanicoEntity);
        return "Actualizacion Exitosa";
    }

    @Override
    public Mecanico consultarInformacionMecanico(Integer idMecanico) throws BusinessException {
        MecanicoEntity mecanicoEntity = mecanicoRepository.findById(idMecanico).orElse(null);
        validarExistaMecanico(mecanicoEntity);
        PersonaEntity personaEntity = personaService.findById(mecanicoEntity.getIdPersona());
        return mecanicoFabrica.entityToModel(mecanicoEntity, personaEntity);
    }

    private void validarExistaMecanico(MecanicoEntity mecanicoEntity) {
        if(mecanicoRepository == null)
            throw new MecanicoNoRegistradoException(MECANICO_NO_EXISTE);
    }

    private void validarNoExistaMecanico(MecanicoCommand mecanicoCommand) {
        int idPersona = mecanicoCommand.getIdPersona();
        List<MecanicoEntity> list = mecanicoRepository.findAll();

        for(MecanicoEntity me : list){
            if(me.getIdPersona() == idPersona)
                throw new MecanicoYaExisteException(MECANICO_YA_REGISTRADO);
        }
    }

    private void validarExistenciaPersona(Integer idPersona) {
        if(personaService.findById(idPersona) == null)
            throw new PersonaNoExisteException(PERSONA_NO_ENCONTRADO);
    }
}
