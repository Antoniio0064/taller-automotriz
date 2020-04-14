package com.ansaca.tallerAutomotriz.model;

import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import com.ansaca.tallerAutomotriz.model.util.Validator;

import javax.xml.bind.ValidationEvent;

public class Propietario extends Persona {

    public static final String NOMBRE_REQUERIDO = "El nombre de una persona es requerido";
    public static final String APELLIDO_REQUERIDO = "El apellido de una persona es requerida";
    public static final String TELEFONO_INVALIDO = "el formato del telefono debe contener 10 dígitos";
    public static final String CORREO_REQUERIDO = "El correo de una persona es requerido";
    public static final String CORREO_FORMATO_INCORRECTO = "el formato ingresado de correo no es el correcto";
    public static final String DIRECCION_REQUERIDA = "La direccion de residencia de una persona es requerida";
    public static final String PAGO_NEGATIVO = "El pago no puede ser un valor negativo";
    public static final String PAGO_VALOR_CERO = "El pago no puede ser un valor de cero";
    public static final String VEHICULO_REQUERIDO = "El vehiculo es requerido";


    private Integer idPropietario;
    private double pago;
    private Vehiculo vehiculo;

    public static class PropietarioBuilder{

        private Integer idPropietario;
        private double pago;
        private Vehiculo vehiculo;

        //Persona
        private Integer idPersona;
        private String nombre;
        private String apellidos;
        private Integer telefono;
        private String correo;
        private String direccion;


        public PropietarioBuilder setIdPropietario(Integer idPropietario) {
            this.idPropietario = idPropietario;
            return this;
        }

        public PropietarioBuilder setPago(Integer pago) {
            this.pago = pago;
            return this;
        }

        public PropietarioBuilder setVehiculo(Vehiculo vehiculo) {
            this.vehiculo = vehiculo;
            return this;
        }

        public PropietarioBuilder setIdPersona(Integer idPersona) {
            this.idPersona = idPersona;
            return this;
        }

        public PropietarioBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public PropietarioBuilder setApellidos(String apellidos) {
            this.apellidos = apellidos;
            return this;
        }

        public PropietarioBuilder setTelefono(Integer telefono) {
            this.telefono = telefono;
            return this;
        }

        public PropietarioBuilder setCorreo(String correo) {
            this.correo = correo;
            return this;
        }

        public PropietarioBuilder setDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Propietario build() throws BusinessException {
            Propietario propietario = new Propietario();
            propietario.idPropietario = this.idPropietario;
            propietario.setIdPersona(this.idPersona);
            Validator.validarNombreNulo(nombre, NOMBRE_REQUERIDO);
            Validator.validarNombreVacio(nombre, NOMBRE_REQUERIDO);
            propietario.setNombre(this.nombre);
            Validator.validarApellidoNulo(apellidos, APELLIDO_REQUERIDO);
            Validator.validarApellidoVacio(apellidos, APELLIDO_REQUERIDO);
            propietario.setApellidos(this.apellidos);
            Validator.validarTelefono(telefono, TELEFONO_INVALIDO);
            propietario.setTelefono(this.telefono);
            Validator.validarCorreoNulo(correo, CORREO_REQUERIDO);
            Validator.validarCorreoVacio(correo, CORREO_REQUERIDO);
            Validator.validarFormatoCorreo(correo, CORREO_FORMATO_INCORRECTO);
            propietario.setCorreo(this.correo);
            Validator.validarDirecionNulo(direccion, DIRECCION_REQUERIDA);
            Validator.validarDirecionVacia(direccion, DIRECCION_REQUERIDA);
            propietario.setDireccion(this.direccion);
            Validator.validarPagoValorNegativo(pago, PAGO_NEGATIVO);
            Validator.validarPagoValorCero(pago, PAGO_VALOR_CERO);
            propietario.pago = this.pago;
            Validator.validarObjetoNulo(vehiculo, VEHICULO_REQUERIDO);
            propietario.vehiculo = this.vehiculo;
            return propietario;
        }
    }

}

