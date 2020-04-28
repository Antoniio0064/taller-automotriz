package com.ansaca.tallerAutomotriz.command;

import com.ansaca.tallerAutomotriz.model.Repuesto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@NoArgsConstructor
public class FacturaCommand {
    private Integer idFactura;
    //private List<Repuesto> RepuestosList = new ArrayList<Repuesto>();
    private double valorManoObra;
    private String descripcionManoObra;
}
