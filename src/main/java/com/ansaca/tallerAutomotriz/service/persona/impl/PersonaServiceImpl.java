package com.ansaca.tallerAutomotriz.service.persona.impl;

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
}
