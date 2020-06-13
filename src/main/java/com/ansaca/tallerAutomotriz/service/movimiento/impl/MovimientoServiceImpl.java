package com.ansaca.tallerAutomotriz.service.movimiento.impl;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.command.MovimientoCommand;
import com.ansaca.tallerAutomotriz.entity.MovimientoEntity;
import com.ansaca.tallerAutomotriz.fabrica.MovimientoFabrica;
import com.ansaca.tallerAutomotriz.model.Repuesto;
import com.ansaca.tallerAutomotriz.model.businessexception.VehiculoNoExisteException;
import com.ansaca.tallerAutomotriz.repository.MovimientoRepository;
import com.ansaca.tallerAutomotriz.service.mecanico.MecanicoService;
import com.ansaca.tallerAutomotriz.service.movimiento.MovimientoService;
import com.ansaca.tallerAutomotriz.service.repuesto.RepuestoService;
import com.ansaca.tallerAutomotriz.service.vehiculo.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    private static final String VEHICULO_NO_ENCONTRADO = "El vehículo no existe.";
    private static final String MOVIMIENTO_CREADO_EXITOSAMENTE = "El movimiento fue registrado exitosamente";

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private MovimientoFabrica movimientoFabrica;

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private RepuestoService repuestoService;

    @Override
    public List<MovimientoCommand> findAll() {
        return movimientoFabrica.entityToCommand(movimientoRepository.findAll());
    }

    @Override
    public String registrarMovimiento(MovimientoCommand movimientoCommand) {
        validarExistenciaVehiculo(movimientoCommand.getPlaca());

        MovimientoEntity movimientoEntity = new MovimientoEntity();
        movimientoEntity.setDetalleMovimiento(movimientoCommand.getDetalleMovimiento());
        movimientoEntity.setFechaIngreso(new Date());
        movimientoEntity.setPlaca(movimientoCommand.getPlaca());
        movimientoEntity.setRepuesto(repuestoService.findById(movimientoCommand.getRepuesto().getIdRepuesto()));
        movimientoRepository.save(movimientoEntity);
        return MOVIMIENTO_CREADO_EXITOSAMENTE;
    }

    private void validarExistenciaVehiculo(String placa) {
        if(vehiculoService.findByPlaca(placa) == null)
            throw new VehiculoNoExisteException(VEHICULO_NO_ENCONTRADO);
    }
}
