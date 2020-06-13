package com.ansaca.tallerAutomotriz.model.businessexception;

public class VehiculoYaExisteException extends RuntimeException {
    public VehiculoYaExisteException(String mensaje) {
        super(mensaje);
    }
}
