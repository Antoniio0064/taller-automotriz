package com.ansaca.tallerAutomotriz.fabrica;

import com.ansaca.tallerAutomotriz.command.PropietarioCommand;
import com.ansaca.tallerAutomotriz.entity.PropietarioEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PropietarioFabrica {

    public List<PropietarioCommand> entityToCommand (List<PropietarioEntity> listaPropietarioEntity){
        List<PropietarioCommand> listaPropietarioCommand = new ArrayList<>();
        listaPropietarioEntity.forEach(e->listaPropietarioCommand.add(entityToCommand(e)));
        return listaPropietarioCommand;
    }

    private PropietarioCommand entityToCommand(PropietarioEntity propietarioEntity) {
        PropietarioCommand propietarioCommand = new PropietarioCommand();
        propietarioCommand.setIdPropietario(propietarioEntity.getIdPropietario());
        propietarioCommand.setPago(propietarioEntity.getPago());
        return propietarioCommand;
    }
}
