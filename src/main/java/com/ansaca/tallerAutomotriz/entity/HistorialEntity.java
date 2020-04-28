package com.ansaca.tallerAutomotriz.entity;

import com.ansaca.tallerAutomotriz.model.Movimiento;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "historial")
public class HistorialEntity {

    @Id
    @GeneratedValue
    @Column(name = "idHistorial")
    private Integer idHistorial;
    //private List<Movimiento> movimientoList = new ArrayList<Movimiento>();
}
