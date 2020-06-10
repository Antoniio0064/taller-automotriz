package com.ansaca.tallerAutomotriz.model.businessexception;

public class VehiculoNoExisteException extends RuntimeException {
    public VehiculoNoExisteException(String mensaje) {
        super(mensaje);
    }
}
