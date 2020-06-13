package com.ansaca.tallerAutomotriz.command;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class PersonaCommand {
    private Integer idPersona;
    private String nombre;
    private String apellidos;
    private Integer telefono;
    private String correo;
    private String direccion;
}
