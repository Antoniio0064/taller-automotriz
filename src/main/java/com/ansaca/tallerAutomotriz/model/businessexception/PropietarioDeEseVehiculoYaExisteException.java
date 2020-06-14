package com.ansaca.tallerAutomotriz.model.businessexception;

public class PropietarioDeEseVehiculoYaExisteException extends RuntimeException {
    public PropietarioDeEseVehiculoYaExisteException(String mensaje){
        super(mensaje);
    }
}
