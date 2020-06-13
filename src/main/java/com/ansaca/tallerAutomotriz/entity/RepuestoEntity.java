package com.ansaca.tallerAutomotriz.entity;


import com.ansaca.tallerAutomotriz.model.Vehiculo;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "repuesto")
public class RepuestoEntity {

    @Id
    @GeneratedValue
    @Column(name = "idRepuesto")
    private Integer idRepuesto;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "valor")
    private double valor;

}
