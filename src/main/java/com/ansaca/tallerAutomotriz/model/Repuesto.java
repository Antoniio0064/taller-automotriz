package com.ansaca.tallerAutomotriz.model;

import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import com.ansaca.tallerAutomotriz.model.util.Validator;

public class Repuesto {
    public static final String NOMBRE_REQUERIDO = "El nombre de un repuesto es requerido";
    public static final String DESCRIPCION_REQUERIDO = "la descripcion de un repuesto es requerida";
    public static final String VALOR_NEGATIVO = "El valor de un respuesto no puede ser negativo";
    public static final String VALOR_CERO = "El valor de un respuesto no puede ser cero";
    public static final String CANTIDAD_NO_VALIDA = "La cantidad de repuestos no puede ser menor o igual a cero";

    private Integer idRepuesto;
    private String nombre;
    private String descripcion;
    private Integer cantidad;
    private double valor;

    public static class RepuestoBuilder{
        private Integer idRepuesto;
        private String nombre;
        private String descripcion;
        private Integer cantidad;
        private double valor;

        public RepuestoBuilder setIdRepuesto(Integer idRepuesto) {
            this.idRepuesto = idRepuesto;
            return this;
        }

        public RepuestoBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public RepuestoBuilder setDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public RepuestoBuilder setValor(double valor) {
            this.valor = valor;
            return this;
        }

        public RepuestoBuilder setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        public Repuesto build() throws BusinessException{
            Repuesto repuesto = new Repuesto();
            repuesto.idRepuesto = this.idRepuesto;
            Validator.validarNombreNulo(nombre, NOMBRE_REQUERIDO);
            Validator.validarNombreVacio(nombre, NOMBRE_REQUERIDO);
            repuesto.nombre = this.nombre;
            Validator.validarDescripcionNulo(descripcion, DESCRIPCION_REQUERIDO);
            Validator.validarDescripcionVacia(descripcion, DESCRIPCION_REQUERIDO);
            repuesto.descripcion = this.descripcion;
            Validator.validarPagoValorNegativo(valor, VALOR_NEGATIVO);
            Validator.validarPagoValorCero(valor, VALOR_CERO);
            repuesto.valor = this.valor;
            Validator.validarCantidadIncorrecta(cantidad, CANTIDAD_NO_VALIDA);
            repuesto.cantidad = this.cantidad;
            return repuesto;
        }
    }

    public Repuesto(){
        super();
    }

    public Integer getIdRepuesto() {
        return idRepuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getValor() {
        return valor;
    }

    public Integer getCantidad() {
        return cantidad;
    }
}
