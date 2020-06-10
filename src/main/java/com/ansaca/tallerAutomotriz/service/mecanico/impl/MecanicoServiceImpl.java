package com.ansaca.tallerAutomotriz.service.mecanico.impl;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.command.MovimientoCommand;
import com.ansaca.tallerAutomotriz.entity.MecanicoEntity;
import com.ansaca.tallerAutomotriz.entity.MovimientoEntity;
import com.ansaca.tallerAutomotriz.fabrica.MecanicoFabrica;
import com.ansaca.tallerAutomotriz.model.businessexception.VehiculoNoExisteException;
import com.ansaca.tallerAutomotriz.repository.MecanicoRepository;
import com.ansaca.tallerAutomotriz.repository.MovimientoRepository;
import com.ansaca.tallerAutomotriz.service.mecanico.MecanicoService;
import com.ansaca.tallerAutomotriz.service.vehiculo.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MecanicoServiceImpl implements MecanicoService {

    private static final String VEHICULO_NO_ENCONTRADO = "El vehículo no existe.";
    private static final String MOVIMIENTO_CREADO_EXITOSAMENTE = "El movimiento fue registrado exitosamente";

    @Autowired
    private MecanicoRepository mecanicoRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private MecanicoFabrica mecanicoFabrica;

    @Override
    public List<MecanicoCommand> findAll() {
        return mecanicoFabrica.entityToCommand(mecanicoRepository.findAll());
    }

    @Override
    public String registrarMovimiento(MovimientoCommand movimientoCommand) {
        validarExistenciaVehiculo(movimientoCommand.getPlaca());

        MovimientoEntity movimientoEntity = new MovimientoEntity();
        movimientoEntity.setDetalleMovimiento(movimientoCommand.getDetalleMovimiento());
        movimientoEntity.setFechaIngreso(movimientoCommand.getFechaIngreso());
        movimientoEntity.setFechaSalida(movimientoCommand.getFechaSalida());
        movimientoEntity.setPlaca(movimientoCommand.getPlaca());
        movimientoEntity.setRepuesto(movimientoCommand.getRepuesto());
        movimientoRepository.save(movimientoEntity);
        return MOVIMIENTO_CREADO_EXITOSAMENTE;
    }

    private void validarExistenciaVehiculo(String placa) {
        if(vehiculoService.findByPlaca(placa) == null)
            throw new VehiculoNoExisteException(VEHICULO_NO_ENCONTRADO);
    }
}
