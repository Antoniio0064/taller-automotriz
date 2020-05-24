package com.ansaca.tallerAutomotriz.command;

import com.ansaca.tallerAutomotriz.entity.HistorialEntity;
import com.ansaca.tallerAutomotriz.model.Historial;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class VehiculoCommand {
    private Integer idVehiculo;
    private String placa;
    private Boolean estado;
    private String tipoVehiculo;
    private HistorialEntity historial;
}
