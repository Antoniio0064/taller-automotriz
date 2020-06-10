package com.ansaca.tallerAutomotriz.service.vehiculo.impl;

import com.ansaca.tallerAutomotriz.command.VehiculoCommand;
import com.ansaca.tallerAutomotriz.entity.VehiculoEntity;
import com.ansaca.tallerAutomotriz.fabrica.VehiculoFabrica;
import com.ansaca.tallerAutomotriz.repository.VehiculoRepository;
import com.ansaca.tallerAutomotriz.service.vehiculo.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private VehiculoFabrica vehiculoFabrica;

    @Override
    public List<VehiculoCommand> findAll() {
        return vehiculoFabrica.entityToCommand(vehiculoRepository.findAll());
    }

    @Override
    public VehiculoEntity findByPlaca(String placa) {
        return vehiculoRepository.findByPlaca(placa);
    }
}
