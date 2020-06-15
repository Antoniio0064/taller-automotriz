package com.ansaca.tallerAutomotriz.fabrica;

import com.ansaca.tallerAutomotriz.command.VehiculoCommand;
import com.ansaca.tallerAutomotriz.entity.MovimientoEntity;
import com.ansaca.tallerAutomotriz.entity.VehiculoEntity;
import com.ansaca.tallerAutomotriz.model.Historial;
import com.ansaca.tallerAutomotriz.model.Vehiculo;
import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehiculoFabrica {

    @Autowired
    private HistorialFabrica historialFabrica;

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

    public Vehiculo entityToModel(VehiculoEntity vehiculoEntity, List<MovimientoEntity> listaMovimientosEntity) throws BusinessException {
        Historial historial = new Historial.HistorialBuilder()
                .setMovimientos(historialFabrica.entityToModel(listaMovimientosEntity)).build();
        Vehiculo vehiculo = new Vehiculo.VehiculoBuilder().setIdVehiculo(vehiculoEntity.getIdVehiculo())
                .setPlaca(vehiculoEntity.getPlaca()).setEstado(vehiculoEntity.getEstado())
                .setTipoVehiculo(vehiculoEntity.getTipoVehiculo()).setHistorial(historial).build();

        return vehiculo;
    }
}
