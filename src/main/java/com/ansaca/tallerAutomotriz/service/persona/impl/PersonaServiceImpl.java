package com.ansaca.tallerAutomotriz.service.persona.impl;

import com.ansaca.tallerAutomotriz.command.PersonaCommand;
import com.ansaca.tallerAutomotriz.entity.PersonaEntity;
import com.ansaca.tallerAutomotriz.repository.PersonaRepository;
import com.ansaca.tallerAutomotriz.service.persona.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public PersonaEntity findById(Integer idPersona) {
        return personaRepository.findById(idPersona).orElse(null);
    }

    @Override
    public String eliminarPersona(Integer id) {
        return null;
    }

    @Override
    public String actualizarPersona(PersonaCommand personaCommand) {
        return null;
    }

    @Override
    public PersonaEntity findByNumeroIdentificacion(Long numeroIdentificacion) {
        return personaRepository.findByNumeroIdentificacion(numeroIdentificacion);
    }
}
