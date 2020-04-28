package com.ansaca.tallerAutomotriz.command;

import com.ansaca.tallerAutomotriz.model.Movimiento;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@NoArgsConstructor
public class HistorialCommand {
    private Integer idHistorial;
    //private List<Movimiento> movimientoList = new ArrayList<Movimiento>();
}
