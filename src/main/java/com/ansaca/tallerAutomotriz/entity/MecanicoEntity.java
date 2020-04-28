package com.ansaca.tallerAutomotriz.entity;

import com.ansaca.tallerAutomotriz.model.Movimiento;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "mecanico")
public class MecanicoEntity {
    @Id
    @GeneratedValue
    @Column(name = "idMecanico")
    private Integer idMecanico;
    @Column(name = "especialidad")
    private String especialidad;
    @Column(name = "disponibilidad")
    private Boolean disponibilidad;
    @ManyToOne
    @JoinColumn(name = "movimiento")
    private MovimientoEntity movimiento;
}
