package com.ansaca.tallerAutomotriz.service.historial.impl;

import com.ansaca.tallerAutomotriz.command.HistorialCommand;
import com.ansaca.tallerAutomotriz.entity.HistorialEntity;
import com.ansaca.tallerAutomotriz.entity.MovimientoEntity;
import com.ansaca.tallerAutomotriz.fabrica.HistorialFabrica;
import com.ansaca.tallerAutomotriz.model.Movimiento;
import com.ansaca.tallerAutomotriz.model.businessexception.VehiculoNoExisteException;
import com.ansaca.tallerAutomotriz.repository.HistorialRepository;
import com.ansaca.tallerAutomotriz.service.historial.HistorialService;
import com.ansaca.tallerAutomotriz.service.movimiento.MovimientoService;
import com.ansaca.tallerAutomotriz.service.vehiculo.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialServiceImpl implements HistorialService {

    private static final String VEHICULO_NO_ENCONTRADO = "El Vehiculo no existe";

    @Autowired
    private HistorialRepository historialRepository;

    @Autowired
    private HistorialFabrica historialFabrica;

    @Autowired
    private MovimientoService movimientoService;

    @Autowired
    private VehiculoService vehiculoService;

    @Override
    public List<HistorialCommand> findAll() {
        return historialFabrica.entityToCommand(historialRepository.findAll());
    }

    @Override
    public HistorialEntity findById(Integer idHistorial) {
        return historialRepository.findById(idHistorial).orElse(null);
    }

    @Override
    public List<Movimiento> consultarHistorialVehiculo(String placa) {
        validarExistenciaVehiculo(placa);
        List<MovimientoEntity> listaMovimientosEntity = movimientoService.findAllByPlaca(placa);
        return  historialFabrica.entityToModel(listaMovimientosEntity);
    }

    private void validarExistenciaVehiculo(String placa) {
        if(vehiculoService.findByPlaca(placa) == null)
            throw new VehiculoNoExisteException(VEHICULO_NO_ENCONTRADO);
    }

}
