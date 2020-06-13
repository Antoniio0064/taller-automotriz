package com.ansaca.tallerAutomotriz.model.businessexception;

public class RepuestoYaExisteException extends RuntimeException {
    public RepuestoYaExisteException(String mensaje){
        super(mensaje);
    }
}
