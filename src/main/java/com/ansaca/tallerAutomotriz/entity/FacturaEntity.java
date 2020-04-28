package com.ansaca.tallerAutomotriz.entity;

import com.ansaca.tallerAutomotriz.model.Repuesto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table( name = "factura")
public class FacturaEntity {

    @Id
    @GeneratedValue
    @Column(name = "idFactura")
    private Integer idFactura;
    @Column(name = "valorManoObra")
    private double valorManoObra;
    @Column(name = "descripcionManoObra")
    private String descripcionManoObra;

    //private List<Repuesto> RepuestosList = new ArrayList<Repuesto>();
}
