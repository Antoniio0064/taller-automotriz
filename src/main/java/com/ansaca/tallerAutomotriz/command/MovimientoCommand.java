package com.ansaca.tallerAutomotriz.command;

import com.ansaca.tallerAutomotriz.entity.RepuestoEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@NoArgsConstructor
public class MovimientoCommand {
    private Integer idMovimiento;
    private Date fechaIngreso;
    private Date fechaSalida;
    private String placa;
    private String detalleMovimiento;
    private RepuestoEntity Repuesto;
}
