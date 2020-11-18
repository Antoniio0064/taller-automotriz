package com.ansaca.tallerAutomotriz.fabrica;

import com.ansaca.tallerAutomotriz.command.PropietarioCommand;
import com.ansaca.tallerAutomotriz.entity.MovimientoEntity;
import com.ansaca.tallerAutomotriz.entity.PersonaEntity;
import com.ansaca.tallerAutomotriz.entity.PropietarioEntity;
import com.ansaca.tallerAutomotriz.entity.VehiculoEntity;
import com.ansaca.tallerAutomotriz.model.*;
import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
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
        propietarioCommand.setIdPersona(propietarioEntity.getIdPersona());
        propietarioCommand.setPago(propietarioEntity.getPago());
        propietarioCommand.setPlaca(propietarioEntity.getPlaca());
        return propietarioCommand;
    }

    public Propietario entityToModel(PropietarioEntity propietarioEntity,
                                     PersonaEntity personaEntity, VehiculoEntity vehiculoEntity,
                                     List<Movimiento> movimientos) throws BusinessException {

        Vehiculo vehiculo = new Vehiculo.VehiculoBuilder().setPlaca(vehiculoEntity.getPlaca())
                .setIdVehiculo(vehiculoEntity.getIdVehiculo()).setTipoVehiculo(vehiculoEntity.getTipoVehiculo())
                .setEstado(vehiculoEntity.getEstado()).setMovimientos(movimientos).build();

        Propietario propietario = new Propietario.PropietarioBuilder()
                .setIdPersona(personaEntity.getIdPersona()).setNumeroIdentificacion(personaEntity.getNumeroIdentificacion())
                .setNombre(personaEntity.getNombre()).setApellidos(personaEntity.getApellidos())
                .setTelefono(personaEntity.getTelefono()).setCorreo(personaEntity.getCorreo())
                .setDireccion(personaEntity.getDireccion()).setIdPropietario(propietarioEntity.getIdPropietario())
                .setPago(propietarioEntity.getPago()).setVehiculo(vehiculo).build();
        return propietario;
    }
}
