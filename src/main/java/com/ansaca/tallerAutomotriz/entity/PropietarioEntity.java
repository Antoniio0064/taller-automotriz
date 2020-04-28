package com.ansaca.tallerAutomotriz.entity;

import com.ansaca.tallerAutomotriz.model.Vehiculo;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "propietario")
public class PropietarioEntity {
    @Id
    @GeneratedValue
    @Column(name = "idPropietario")
    private Integer idPropietario;
    @Column(name = "pago")
    private double pago;
    @ManyToOne
    @JoinColumn(name = "vehiculo")
    private VehiculoEntity vehiculo;


}
