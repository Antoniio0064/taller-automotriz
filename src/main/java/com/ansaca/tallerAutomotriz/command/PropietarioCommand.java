package com.ansaca.tallerAutomotriz.command;

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
    private Vehiculo vehiculo;
}
