package com.ansaca.tallerAutomotriz.service.historial.impl;

import com.ansaca.tallerAutomotriz.command.HistorialCommand;
import com.ansaca.tallerAutomotriz.entity.HistorialEntity;
import com.ansaca.tallerAutomotriz.fabrica.HistorialFabrica;
import com.ansaca.tallerAutomotriz.repository.HistorialRepository;
import com.ansaca.tallerAutomotriz.service.historial.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialServiceImpl implements HistorialService {

    @Autowired
    private HistorialRepository historialRepository;

    @Autowired
    private HistorialFabrica historialFabrica;

    @Override
    public List<HistorialCommand> findAll() {
        return historialFabrica.entityToCommand(historialRepository.findAll());
    }
}
