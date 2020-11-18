package com.ansaca.tallerAutomotriz.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vehiculo")
public class VehiculoEntity {

    @Id
    @GeneratedValue
    @Column(name = "idVehiculo")
    private Integer idVehiculo;
    @Column(name = "placa")
    private String placa;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "tipoVehiculo")
    private String tipoVehiculo;
    //@Column(name = "idHistorial")
    //private Integer idHistorial;

}
