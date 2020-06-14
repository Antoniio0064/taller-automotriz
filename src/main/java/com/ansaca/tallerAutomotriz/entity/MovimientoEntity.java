package com.ansaca.tallerAutomotriz.entity;

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
    @Column(name = "detalleMovimiento")
    private String detalleMovimiento;
    @Column(name = "finalizado")
    private boolean finalizado;
    @Column(name = "idRepuesto")
    private Integer idRepuesto;
}
