package com.ansaca.tallerAutomotriz.service.factura.impl;

import com.ansaca.tallerAutomotriz.command.FacturaCommand;
import com.ansaca.tallerAutomotriz.entity.FacturaEntity;
import com.ansaca.tallerAutomotriz.entity.RepuestoEntity;
import com.ansaca.tallerAutomotriz.fabrica.FacturaFabrica;
import com.ansaca.tallerAutomotriz.repository.FacturaRepository;
import com.ansaca.tallerAutomotriz.repository.RepuestoRepository;
import com.ansaca.tallerAutomotriz.service.factura.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private FacturaFabrica facturaFabrica;

    @Override
    public List<FacturaCommand> findAll() {
        return facturaFabrica.entityToCommand(facturaRepository.findAll());
    }
}
