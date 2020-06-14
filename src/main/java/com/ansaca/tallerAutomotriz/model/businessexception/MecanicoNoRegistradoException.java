package com.ansaca.tallerAutomotriz.model.businessexception;

public class MecanicoNoRegistradoException extends RuntimeException {
    public MecanicoNoRegistradoException(String mensaje){
        super(mensaje);
    }
}
