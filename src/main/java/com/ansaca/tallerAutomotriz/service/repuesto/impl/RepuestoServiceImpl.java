package com.ansaca.tallerAutomotriz.service.repuesto.impl;

import com.ansaca.tallerAutomotriz.command.RepuestoCommand;
import com.ansaca.tallerAutomotriz.entity.RepuestoEntity;
import com.ansaca.tallerAutomotriz.fabrica.RepuestoFabrica;
import com.ansaca.tallerAutomotriz.repository.RepuestoRepository;
import com.ansaca.tallerAutomotriz.service.repuesto.RepuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepuestoServiceImpl implements RepuestoService {

    @Autowired
    private RepuestoRepository repuestoRepository;

    @Autowired
    private RepuestoFabrica repuestoFabrica;

    @Override
    public List<RepuestoCommand> findAll() {
        return repuestoFabrica.entityToCommand(repuestoRepository.findAll());
    }
}
