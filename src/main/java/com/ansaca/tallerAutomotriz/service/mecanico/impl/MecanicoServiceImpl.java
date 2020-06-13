package com.ansaca.tallerAutomotriz.service.mecanico.impl;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.command.MovimientoCommand;
import com.ansaca.tallerAutomotriz.command.PersonaCommand;
import com.ansaca.tallerAutomotriz.entity.MecanicoEntity;
import com.ansaca.tallerAutomotriz.entity.MovimientoEntity;
import com.ansaca.tallerAutomotriz.entity.PersonaEntity;
import com.ansaca.tallerAutomotriz.fabrica.MecanicoFabrica;
import com.ansaca.tallerAutomotriz.model.businessexception.MecanicoYaExisteException;
import com.ansaca.tallerAutomotriz.model.businessexception.PersonaNoExisteException;
import com.ansaca.tallerAutomotriz.model.businessexception.VehiculoNoExisteException;
import com.ansaca.tallerAutomotriz.repository.MecanicoRepository;
import com.ansaca.tallerAutomotriz.repository.MovimientoRepository;
import com.ansaca.tallerAutomotriz.repository.PersonaRepository;
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
        validarExistenciaPersona(mecanicoCommand.getPersona().getIdPersona());
        validarNoExistaMecanico(mecanicoCommand);

        MecanicoEntity mecanicoEntity = new MecanicoEntity();
        mecanicoEntity.setEspecialidad(mecanicoCommand.getEspecialidad());
        mecanicoEntity.setDisponibilidad(mecanicoCommand.getDisponibilidad());
        mecanicoEntity.setPersona(mecanicoCommand.getPersona());
        mecanicoRepository.save(mecanicoEntity);
        return MECANICO_CREADO_EXITOSAMENTE;
    }

    private void validarNoExistaMecanico(MecanicoCommand mecanicoCommand) {
        int idPersona = mecanicoCommand.getPersona().getIdPersona();
        List<MecanicoEntity> list = mecanicoRepository.findAll();

        for(MecanicoEntity me : list){
            if(me.getPersona().getIdPersona() == idPersona)
                throw new MecanicoYaExisteException(MECANICO_YA_REGISTRADO);
        }
    }

    private void validarExistenciaPersona(Integer idPersona) {
        if(personaService.findById(idPersona) == null)
            throw new PersonaNoExisteException(PERSONA_NO_ENCONTRADO);
    }
}
