package com.ansaca.tallerAutomotriz.fabrica;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.entity.MecanicoEntity;
import com.ansaca.tallerAutomotriz.entity.PersonaEntity;
import com.ansaca.tallerAutomotriz.model.Mecanico;
import com.ansaca.tallerAutomotriz.model.Persona;
import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MecanicoFabrica {

    public List<MecanicoCommand> entityToCommand(List<MecanicoEntity> listaMecanicoEntity){
        List<MecanicoCommand> listaMecanicoCommand = new ArrayList<>();
        listaMecanicoEntity.forEach(e->listaMecanicoCommand.add(entityToCommand(e)));
        return listaMecanicoCommand;
    }

    public MecanicoCommand entityToCommand(MecanicoEntity mecanicoEntity) {
        MecanicoCommand mecanicoCommand = new MecanicoCommand();
        mecanicoCommand.setIdMecanico(mecanicoEntity.getIdMecanico());
        mecanicoCommand.setDisponibilidad(mecanicoEntity.getDisponibilidad());
        mecanicoCommand.setEspecialidad(mecanicoEntity.getEspecialidad());
        mecanicoCommand.setIdPersona(mecanicoEntity.getIdPersona());
        return mecanicoCommand;
    }

    public Mecanico entityToModel(MecanicoEntity mecanicoEntity, PersonaEntity personaEntity) throws BusinessException {
        Mecanico mecanico = new Mecanico.MecanicoBuilder()
                .setIdPersona(personaEntity.getIdPersona()).setNumeroIdentificacion(personaEntity.getNumeroIdentificacion())
                .setNombre(personaEntity.getNombre()).setApellidos(personaEntity.getApellidos())
                .setTelefono(personaEntity.getTelefono()).setCorreo(personaEntity.getCorreo())
                .setDireccion(personaEntity.getDireccion()).setIdMecanico(mecanicoEntity.getIdMecanico())
                .setEspecialidad(mecanicoEntity.getEspecialidad()).setDisponibilidad(mecanicoEntity.getDisponibilidad())
                .build();

        return mecanico;
    }
}
