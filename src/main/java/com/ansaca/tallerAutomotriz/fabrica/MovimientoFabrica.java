package com.ansaca.tallerAutomotriz.fabrica;

import com.ansaca.tallerAutomotriz.command.MovimientoCommand;
import com.ansaca.tallerAutomotriz.entity.MovimientoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovimientoFabrica {

    public List<MovimientoCommand> entityToCommand (List<MovimientoEntity> listaMovimientoEntity){
        List<MovimientoCommand> listaMovimientoCommand = new ArrayList<>();
        listaMovimientoEntity.forEach(e->listaMovimientoCommand.add(entityToCommand(e)));
        return listaMovimientoCommand;
    }

    private MovimientoCommand entityToCommand(MovimientoEntity movimientoEntity) {
        MovimientoCommand movimientoCommand = new MovimientoCommand();
        movimientoCommand.setIdMovimiento(movimientoEntity.getIdMovimiento());
        movimientoCommand.setPlaca(movimientoEntity.getPlaca());
        movimientoCommand.setFechaIngreso(movimientoEntity.getFechaIngreso());
        movimientoCommand.setFechaSalida(movimientoEntity.getFechaSalida());
        movimientoCommand.setDetalleMovimiento(movimientoEntity.getDetalleMovimiento());
        movimientoCommand.setRepuesto(movimientoEntity.getRepuesto());
        return movimientoCommand;
    }
}
