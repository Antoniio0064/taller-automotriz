package com.ansaca.tallerAutomotriz.fabrica;

import com.ansaca.tallerAutomotriz.command.HistorialCommand;
import com.ansaca.tallerAutomotriz.entity.HistorialEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistorialFabrica {

    public List<HistorialCommand> entityToCommand(List<HistorialEntity> listaHistorialEntity) {
        List<HistorialCommand> listaHistorialCommand = new ArrayList<>();
        listaHistorialEntity.forEach(e-> listaHistorialCommand.add(entityToCommand(e)));
        return listaHistorialCommand;
    }

    private HistorialCommand entityToCommand(HistorialEntity historialEntity) {
        HistorialCommand historialCommand = new HistorialCommand();
        historialCommand.setIdHistorial(historialEntity.getIdHistorial());
        return historialCommand;
    }


}
