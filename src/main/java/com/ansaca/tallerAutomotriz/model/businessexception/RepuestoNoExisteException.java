package com.ansaca.tallerAutomotriz.model.businessexception;

public class RepuestoNoExisteException extends RuntimeException {
    public RepuestoNoExisteException(String mensaje){
        super(mensaje);
    }
}
