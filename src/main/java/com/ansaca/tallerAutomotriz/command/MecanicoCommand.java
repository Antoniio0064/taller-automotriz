package com.ansaca.tallerAutomotriz.command;

import com.ansaca.tallerAutomotriz.entity.MovimientoEntity;
import com.ansaca.tallerAutomotriz.entity.PersonaEntity;
import com.ansaca.tallerAutomotriz.model.Movimiento;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class MecanicoCommand {
    private Integer idMecanico;
    private String especialidad;
    private Boolean disponibilidad;
    private Integer idPersona;
}
