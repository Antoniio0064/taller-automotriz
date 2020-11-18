package com.ansaca.tallerAutomotriz.service.persona;

import com.ansaca.tallerAutomotriz.command.MecanicoCommand;
import com.ansaca.tallerAutomotriz.command.PersonaCommand;
import com.ansaca.tallerAutomotriz.entity.PersonaEntity;

public interface PersonaService {
    PersonaEntity findById(Integer idPersona);

    String eliminarPersona(Integer id);

    String actualizarPersona(PersonaCommand personaCommand);

    PersonaEntity findByNumeroIdentificacion(Long numeroIdentificacion);
}
