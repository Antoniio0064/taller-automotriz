package com.ansaca.tallerAutomotriz.command;

import com.ansaca.tallerAutomotriz.entity.PersonaEntity;
import com.ansaca.tallerAutomotriz.entity.VehiculoEntity;
import com.ansaca.tallerAutomotriz.model.Vehiculo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class PropietarioCommand {
    private Integer idPropietario;
    private double pago;
    private PersonaEntity persona;
    private VehiculoEntity vehiculo;
}
