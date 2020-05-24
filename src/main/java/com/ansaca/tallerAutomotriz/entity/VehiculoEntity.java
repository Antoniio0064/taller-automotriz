package com.ansaca.tallerAutomotriz.entity;

import com.ansaca.tallerAutomotriz.model.Historial;
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
    @OneToOne
    @JoinColumn(name = "idHistorial")
    private HistorialEntity Historial;

}
