package com.ansaca.tallerAutomotriz.model.businessexception;

public class MecanicoYaExisteException extends RuntimeException {
    public MecanicoYaExisteException(String mensaje){
        super(mensaje);
    }
}
