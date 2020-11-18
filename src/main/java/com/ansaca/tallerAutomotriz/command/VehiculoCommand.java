package com.ansaca.tallerAutomotriz.command;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class VehiculoCommand {
    private int idVehiculo;
    private String placa;
    private Boolean estado;
    private String tipoVehiculo;
}
