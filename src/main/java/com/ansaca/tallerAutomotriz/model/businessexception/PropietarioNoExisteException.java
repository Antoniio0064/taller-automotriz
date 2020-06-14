package com.ansaca.tallerAutomotriz.model.businessexception;

public class PropietarioNoExisteException extends RuntimeException {
    public PropietarioNoExisteException(String mensaje){
        super(mensaje);
    }
}
