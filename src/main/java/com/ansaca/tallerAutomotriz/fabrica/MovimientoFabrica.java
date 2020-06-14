package com.ansaca.tallerAutomotriz.fabrica;

import com.ansaca.tallerAutomotriz.command.MovimientoCommand;
import com.ansaca.tallerAutomotriz.entity.MovimientoEntity;
import com.ansaca.tallerAutomotriz.entity.RepuestoEntity;
import com.ansaca.tallerAutomotriz.model.Movimiento;
import com.ansaca.tallerAutomotriz.model.Repuesto;
import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
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
        movimientoCommand.setIdRepuesto(movimientoEntity.getIdRepuesto());
        return movimientoCommand;
    }

    public Movimiento entityToModel(MovimientoEntity movimientoEntity, RepuestoEntity repuestoEntity) throws BusinessException {
        Repuesto repuesto = new Repuesto.RepuestoBuilder()
                .setIdRepuesto(repuestoEntity.getIdRepuesto()).setNombre(repuestoEntity.getNombre())
                .setDescripcion(repuestoEntity.getDescripcion()).setValor(repuestoEntity.getValor())
                .setCantidad(repuestoEntity.getCantidad()).build();
        Movimiento movimiento = new Movimiento.MovimientoBuilder()
                .setIdMovimiento(movimientoEntity.getIdMovimiento()).setPlaca(movimientoEntity.getPlaca())
                .setFechaIngreso(movimientoEntity.getFechaIngreso()).setFechaSalida(movimientoEntity.getFechaSalida())
                .setDetalleMovimiento(movimientoEntity.getDetalleMovimiento()).setRepuesto(repuesto)
                .build();
        return movimiento;
    }
}
