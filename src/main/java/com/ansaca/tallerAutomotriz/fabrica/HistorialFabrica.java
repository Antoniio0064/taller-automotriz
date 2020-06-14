package com.ansaca.tallerAutomotriz.fabrica;

import com.ansaca.tallerAutomotriz.command.HistorialCommand;
import com.ansaca.tallerAutomotriz.entity.HistorialEntity;
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
public class HistorialFabrica {

    @Autowired
    RepuestoService repuestoService;

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
