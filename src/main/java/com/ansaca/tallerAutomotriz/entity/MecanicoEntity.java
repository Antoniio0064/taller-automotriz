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
    @ManyToOne
    @JoinColumn(name = "idPersona")
    private  PersonaEntity persona;
    @Column(name = "especialidad")
    private String especialidad;
    @Column(name = "disponibilidad")
    private Boolean disponibilidad;
}
