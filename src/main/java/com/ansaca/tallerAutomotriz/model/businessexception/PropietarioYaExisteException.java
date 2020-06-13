package com.ansaca.tallerAutomotriz.model.businessexception;

public class PropietarioYaExisteException extends RuntimeException {
    public PropietarioYaExisteException(String mensaje){
        super(mensaje);
    }
}
