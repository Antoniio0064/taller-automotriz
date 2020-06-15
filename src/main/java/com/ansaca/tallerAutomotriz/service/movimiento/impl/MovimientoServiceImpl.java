package com.ansaca.tallerAutomotriz.service.movimiento.impl;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.command.MovimientoCommand;
import com.ansaca.tallerAutomotriz.entity.MovimientoEntity;
import com.ansaca.tallerAutomotriz.entity.RepuestoEntity;
import com.ansaca.tallerAutomotriz.fabrica.MovimientoFabrica;
import com.ansaca.tallerAutomotriz.model.Movimiento;
import com.ansaca.tallerAutomotriz.model.Repuesto;
import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import com.ansaca.tallerAutomotriz.model.businessexception.RepuestoNoExisteException;
import com.ansaca.tallerAutomotriz.model.businessexception.VehiculoEnReparacionException;
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
    private static final String VEHICULO_EN_REPARACION = "No puede registrar un movimiento, el vehículo se encuentra en reparacion";
    private static final String REPUESTO_NO_EXISTE = "El repuesto que intenta asignar no esta registrado";
    private static final String VEHICULO_NO_REGISTRADO_EN_REPARACION = "El vehiculo no aparece como en zona de reparación";

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
        validarVehiculoEnReparacion(movimientoCommand.getPlaca());
        validarExistenciaRepuesto(movimientoCommand.getIdRepuesto());

        MovimientoEntity movimientoEntity = new MovimientoEntity();
        movimientoEntity.setFinalizado(false);
        movimientoEntity.setFechaIngreso(new Date());
        movimientoEntity.setPlaca(movimientoCommand.getPlaca());
        movimientoEntity.setIdRepuesto(movimientoCommand.getIdRepuesto());
        movimientoEntity.setDetalleMovimiento(movimientoCommand.getDetalleMovimiento());
        movimientoRepository.save(movimientoEntity);
        return MOVIMIENTO_CREADO_EXITOSAMENTE;
    }

    private void validarExistenciaRepuesto(Integer idRepuesto) {
        if(repuestoService.findById(idRepuesto) == null)
            throw new RepuestoNoExisteException(REPUESTO_NO_EXISTE);
    }

    @Override
    public Movimiento registrarMovimientoFinalizado(String placa) throws BusinessException {
        MovimientoEntity movimientoEntity = movimientoRepository.findByPlacaAndFinalizado(placa,false);
        validarVehiculoSinEstadoReparacion(movimientoEntity);
        movimientoEntity.setFechaSalida(new Date());
        movimientoEntity.setFinalizado(true);
        movimientoRepository.save(movimientoEntity);
        RepuestoEntity repuestoEntity = repuestoService.findById(movimientoEntity.getIdRepuesto());
        return movimientoFabrica.entityToModel(movimientoEntity, repuestoEntity);
    }

    @Override
    public List<MovimientoEntity> findAllByPlaca(String placa) {
        return movimientoRepository.findAllByPlaca(placa);
    }

    private void validarVehiculoEnReparacion(String placa) {
        List<MovimientoEntity> listaMovimientoEntity = movimientoRepository.findAllByPlaca(placa);

        if(listaMovimientoEntity != null) {
            for (MovimientoEntity me : listaMovimientoEntity) {
                if(!me.isFinalizado())
                    throw new VehiculoEnReparacionException(VEHICULO_EN_REPARACION);
            }
        }
    }

    private void validarExistenciaVehiculo(String placa) {
        if(vehiculoService.findByPlaca(placa) == null)
            throw new VehiculoNoExisteException(VEHICULO_NO_ENCONTRADO);
    }
    private void validarVehiculoSinEstadoReparacion(MovimientoEntity movimientoEntity) {
        if(movimientoEntity == null)
            throw new VehiculoNoExisteException(VEHICULO_NO_REGISTRADO_EN_REPARACION);
    }
}
