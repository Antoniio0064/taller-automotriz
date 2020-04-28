package com.ansaca.tallerAutomotriz.service.mecanico.impl;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.entity.MecanicoEntity;
import com.ansaca.tallerAutomotriz.fabrica.MecanicoFabrica;
import com.ansaca.tallerAutomotriz.repository.MecanicoRepository;
import com.ansaca.tallerAutomotriz.service.mecanico.MecanicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MecanicoServiceImpl implements MecanicoService {

    @Autowired
    private MecanicoRepository mecanicoRepository;

    @Autowired
    private MecanicoFabrica mecanicoFabrica;

    @Override
    public List<MecanicoCommand> findAll() {
        return mecanicoFabrica.entityToCommand(mecanicoRepository.findAll());
    }
}
