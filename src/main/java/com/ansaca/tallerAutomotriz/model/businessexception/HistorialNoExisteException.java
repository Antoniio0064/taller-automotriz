package com.ansaca.tallerAutomotriz.model.businessexception;

public class HistorialNoExisteException extends RuntimeException {
    public HistorialNoExisteException(String mensaje){
        super(mensaje);
    }
}
