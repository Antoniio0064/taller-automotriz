package com.ansaca.tallerAutomotriz.fabrica;

import com.ansaca.tallerAutomotriz.command.MovimientoCommand;
import com.ansaca.tallerAutomotriz.entity.MovimientoEntity;
import com.ansaca.tallerAutomotriz.entity.RepuestoEntity;
import com.ansaca.tallerAutomotriz.model.Movimiento;
import com.ansaca.tallerAutomotriz.model.Repuesto;
import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import com.ansaca.tallerAutomotriz.service.repuesto.RepuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovimientoFabrica {

    @Autowired
    private RepuestoService repuestoService;

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

    public List<Movimiento> entityToModel(List<MovimientoEntity> listaMovimientosEntity) {
        List<Movimiento> listaMovimientos = new ArrayList<>();
        listaMovimientosEntity.forEach(e-> {
            try {
                listaMovimientos.add(entityToModel(e));
            } catch (BusinessException ex) {
                ex.printStackTrace();
            }
        });
        return listaMovimientos;
    }

    private Movimiento entityToModel(MovimientoEntity e) throws BusinessException {
        RepuestoEntity repuestoEntity = repuestoService.findById(e.getIdRepuesto());
        Repuesto repuesto = new Repuesto.RepuestoBuilder()
                .setIdRepuesto(repuestoEntity.getIdRepuesto()).setNombre(repuestoEntity.getNombre())
                .setDescripcion(repuestoEntity.getDescripcion()).setCantidad(repuestoEntity.getCantidad())
                .setValor(repuestoEntity.getValor()).build();
        Movimiento movimiento = new Movimiento.MovimientoBuilder()
                .setIdMovimiento(e.getIdMovimiento()).setFechaIngreso(e.getFechaIngreso())
                .setFechaSalida(e.getFechaSalida()).setDetalleMovimiento(e.getDetalleMovimiento())
                .setPlaca(e.getPlaca()).setRepuesto(repuesto).build();
        return movimiento;
    }
}
