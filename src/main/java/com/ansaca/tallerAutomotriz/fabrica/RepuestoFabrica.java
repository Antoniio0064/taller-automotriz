package com.ansaca.tallerAutomotriz.fabrica;

import com.ansaca.tallerAutomotriz.command.RepuestoCommand;
import com.ansaca.tallerAutomotriz.entity.RepuestoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RepuestoFabrica {

    public List<RepuestoCommand> entityToCommand(List<RepuestoEntity> listaRepuestoEntity) {
        List<RepuestoCommand> listaRepuestoCommand = new ArrayList<>();
        listaRepuestoEntity.forEach(e-> listaRepuestoCommand.add(entityToCommand(e)));
        return listaRepuestoCommand;
    }

    public RepuestoCommand entityToCommand(RepuestoEntity repuestoEntity){
        RepuestoCommand repuestoCommand = new RepuestoCommand();
        repuestoCommand.setIdRepuesto(repuestoEntity.getIdRepuesto());
        repuestoCommand.setNombre(repuestoEntity.getNombre());
        repuestoCommand.setDescripcion(repuestoEntity.getDescripcion());
        repuestoCommand.setCantidad(repuestoEntity.getCantidad());
        repuestoCommand.setValor(repuestoEntity.getValor());
        return repuestoCommand;
    }
}
