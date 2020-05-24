package com.ansaca.tallerAutomotriz.entity;

import com.ansaca.tallerAutomotriz.model.Factura;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table (name = "movimiento")
public class MovimientoEntity {

    @Id
    @GeneratedValue
    @Column(name = "idMovimiento")
    private Integer idMovimiento;
    @Column(name = "fechaIngreso")
    private Date fechaIngreso;
    @Column(name = "fechaSalida")
    private Date fechaSalida;
    @Column(name = "placa")
    private String placa;
    @OneToOne
    @JoinColumn(name = "idFactura")
    private FacturaEntity Factura;
}
