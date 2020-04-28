package com.ansaca.tallerAutomotriz.service.movimiento.impl;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.command.MovimientoCommand;
import com.ansaca.tallerAutomotriz.entity.MovimientoEntity;
import com.ansaca.tallerAutomotriz.fabrica.MovimientoFabrica;
import com.ansaca.tallerAutomotriz.repository.MovimientoRepository;
import com.ansaca.tallerAutomotriz.service.mecanico.MecanicoService;
import com.ansaca.tallerAutomotriz.service.movimiento.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private MovimientoFabrica movimientoFabrica;

    @Override
    public List<MovimientoCommand> findAll() {
        return movimientoFabrica.entityToCommand(movimientoRepository.findAll());
    }
}
