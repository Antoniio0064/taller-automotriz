package com.ansaca.tallerAutomotriz.model.businessexception;

public class PersonaNoExisteException extends RuntimeException {
    public PersonaNoExisteException(String mensaje) {
        super(mensaje);
    }
}
