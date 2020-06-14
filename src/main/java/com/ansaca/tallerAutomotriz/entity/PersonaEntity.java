package com.ansaca.tallerAutomotriz.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="persona")
public class PersonaEntity {
    @Id
    @GeneratedValue
    @Column(name = "idPersona")
    private Integer idPersona;
    @Column(name = "numeroIdentificacion")
    private Long numeroIdentificacion;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "telefono")
    private Long telefono;
    @Column(name = "correo")
    private String correo;
    @Column(name = "direccion")
    private String direccion;

}
