package com.ansaca.tallerAutomotriz.service.factura;

import com.ansaca.tallerAutomotriz.command.FacturaCommand;
import com.ansaca.tallerAutomotriz.entity.FacturaEntity;

import java.util.List;

public interface FacturaService {
    List<FacturaCommand> findAll();
}
