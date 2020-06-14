package com.ansaca.tallerAutomotriz.service.persona;

import com.ansaca.tallerAutomotriz.entity.PersonaEntity;

public interface PersonaService {
    PersonaEntity findById(Integer idPersona);

    PersonaEntity findByNumeroIdentificacion(Long numeroIdentificacion);
}
