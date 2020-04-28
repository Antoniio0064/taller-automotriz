package com.ansaca.tallerAutomotriz.service.propietario.impl;

import com.ansaca.tallerAutomotriz.command.PropietarioCommand;
import com.ansaca.tallerAutomotriz.entity.PropietarioEntity;
import com.ansaca.tallerAutomotriz.fabrica.PropietarioFabrica;
import com.ansaca.tallerAutomotriz.repository.PropietarioRepository;
import com.ansaca.tallerAutomotriz.service.propietario.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioServiceImpl implements PropietarioService {

    @Autowired
    private PropietarioRepository propietarioRepository;

    @Autowired
    private PropietarioFabrica propietarioFabrica;

    @Override
    public List<PropietarioCommand> findAll() {
        return propietarioFabrica.entityToCommand(propietarioRepository.findAll());
    }
}
