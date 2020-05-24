package com.ansaca.tallerAutomotriz.fabrica;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.entity.MecanicoEntity;
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

    private MecanicoCommand entityToCommand(MecanicoEntity mecanicoEntity) {
        MecanicoCommand mecanicoCommand = new MecanicoCommand();
        mecanicoCommand.setIdMecanico(mecanicoEntity.getIdMecanico());
        mecanicoCommand.setDisponibilidad(mecanicoEntity.getDisponibilidad());
        mecanicoCommand.setEspecialidad(mecanicoEntity.getEspecialidad());
        mecanicoCommand.setMovimiento(mecanicoEntity.getMovimiento());
        mecanicoCommand.setPersona(mecanicoEntity.getPersona());
        return mecanicoCommand;
    }
}
