package com.ansaca.tallerAutomotriz.command;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class RepuestoCommand {
    private Integer idRepuesto;
    private String nombre;
    private String descripcion;
    private Integer cantidad;
    private double valor;
}
