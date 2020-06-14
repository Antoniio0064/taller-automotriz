package com.ansaca.tallerAutomotriz.fabrica;

import com.ansaca.tallerAutomotriz.command.VehiculoCommand;
import com.ansaca.tallerAutomotriz.entity.VehiculoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehiculoFabrica {

    public List<VehiculoCommand> entityToCommand(List<VehiculoEntity> listaVehiculoEntity){
        List<VehiculoCommand> listaVehiculoCommand = new ArrayList<>();
        listaVehiculoEntity.forEach(e->listaVehiculoCommand.add(entityToCommand(e)));
        return listaVehiculoCommand;
    }

    private VehiculoCommand entityToCommand(VehiculoEntity vehiculoEntity) {
        VehiculoCommand vehiculoCommand = new VehiculoCommand();
        vehiculoCommand.setIdVehiculo(vehiculoEntity.getIdVehiculo());
        vehiculoCommand.setPlaca(vehiculoEntity.getPlaca());
        vehiculoCommand.setEstado(vehiculoEntity.getEstado());
        vehiculoCommand.setTipoVehiculo(vehiculoEntity.getTipoVehiculo());
        vehiculoCommand.setIdHistorial(vehiculoEntity.getIdHistorial());
        return vehiculoCommand;
    }
}
