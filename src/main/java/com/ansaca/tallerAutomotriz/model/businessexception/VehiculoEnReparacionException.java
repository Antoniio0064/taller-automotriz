package com.ansaca.tallerAutomotriz.model.businessexception;

public class VehiculoEnReparacionException extends RuntimeException {

    public VehiculoEnReparacionException(String mensaje){
        super(mensaje);
    }
}
