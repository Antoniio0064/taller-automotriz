package com.ansaca.tallerAutomotriz.service.propietario.impl;

import com.ansaca.tallerAutomotriz.command.PropietarioCommand;
import com.ansaca.tallerAutomotriz.entity.MecanicoEntity;
import com.ansaca.tallerAutomotriz.entity.PropietarioEntity;
import com.ansaca.tallerAutomotriz.fabrica.PropietarioFabrica;
import com.ansaca.tallerAutomotriz.model.businessexception.MecanicoYaExisteException;
import com.ansaca.tallerAutomotriz.model.businessexception.PersonaNoExisteException;
import com.ansaca.tallerAutomotriz.model.businessexception.PropietarioYaExisteException;
import com.ansaca.tallerAutomotriz.repository.PropietarioRepository;
import com.ansaca.tallerAutomotriz.service.persona.PersonaService;
import com.ansaca.tallerAutomotriz.service.propietario.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioServiceImpl implements PropietarioService {

    private static final String PROPIETARIO_CREADO_EXITOSAMENTE = "El propietario fue registrado exitosamente";
    private static final String PROPIETARIO_YA_REGISTRADO = "El propietario que intenta registrar ya se encuentra en el sistema";
    private static final String PERSONA_NO_ENCONTRADO = "La persona a la que desea asignar como propietario no existe";

    @Autowired
    private PropietarioRepository propietarioRepository;

    @Autowired
    private PropietarioFabrica propietarioFabrica;

    @Autowired
    private PersonaService personaService;

    @Override
    public List<PropietarioCommand> findAll() {
        return propietarioFabrica.entityToCommand(propietarioRepository.findAll());
    }

    @Override
    public String registrarPropietario(PropietarioCommand propietarioCommand) {
        validarExistenciaPersona(propietarioCommand.getPersona().getIdPersona());
        validarNoExistaPropietario(propietarioCommand);

        PropietarioEntity  propietarioEntity = new PropietarioEntity();
        propietarioEntity.setPago(propietarioCommand.getPago());
        propietarioEntity.setPersona(propietarioCommand.getPersona());
        propietarioEntity.setVehiculo(propietarioCommand.getVehiculo());
        propietarioRepository.save(propietarioEntity);

        return PROPIETARIO_CREADO_EXITOSAMENTE;
    }

    private void validarNoExistaPropietario(PropietarioCommand propietarioCommand) {
        int idPersona = propietarioCommand.getPersona().getIdPersona();
        List<PropietarioEntity> list = propietarioRepository.findAll();

        for(PropietarioEntity pe : list){
            if(pe.getPersona().getIdPersona() == idPersona)
                throw new PropietarioYaExisteException(PROPIETARIO_YA_REGISTRADO);
        }
    }

    private void validarExistenciaPersona(Integer idPersona) {
        if(personaService.findById(idPersona) == null)
            throw new PersonaNoExisteException(PERSONA_NO_ENCONTRADO);
    }
}
