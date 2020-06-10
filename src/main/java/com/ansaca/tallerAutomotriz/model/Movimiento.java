package com.ansaca.tallerAutomotriz.model;

import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import com.ansaca.tallerAutomotriz.model.util.Validator;

import java.util.Date;

public class Movimiento {

    public static final String FECHA_INGRESO_REQUERIDA = "La fecha de ingreso es requerida";
    public static final String FECHA_SALIDA_REQUERIDA = "La fecha de salida es requerida";
    public static final String PLACA_REQUERIDA = "La placa de un vehiculo es requerida";
    public static final String FACTURA_NO_CONFIGURADA = "La factura no fue configurada";

    private Integer idMovimiento;
    private Date fechaIngreso;
    private Date fechaSalida;
    private String placa;
    private String detalleMovimiento;
    private Repuesto repuesto;

    public static class MovimientoBuilder{
        private Integer idMovimiento;
        private Date fechaIngreso;
        private Date fechaSalida;
        private String placa;
        private String detalleMovimiento;
        private Repuesto repuesto;

        public MovimientoBuilder setIdMovimiento(Integer idMovimiento) {
            this.idMovimiento = idMovimiento;
            return this;
        }

        public MovimientoBuilder setFechaIngreso(Date fechaIngreso) {
            this.fechaIngreso = fechaIngreso;
            return this;
        }

        public MovimientoBuilder setFechaSalida(Date fechaSalida) {
            this.fechaSalida = fechaSalida;
            return this;
        }

        public MovimientoBuilder setPlaca(String placa) {
            this.placa = placa;
            return this;
        }

        public MovimientoBuilder setDetalleMovimiento(String detalleMovimiento) {
            this.detalleMovimiento = detalleMovimiento;
            return this;
        }

        public MovimientoBuilder setRepuesto(Repuesto repuesto) {
            this.repuesto = repuesto;
            return this;
        }

        public Movimiento build() throws BusinessException{
            Movimiento movimiento = new Movimiento();
            movimiento.idMovimiento = this.idMovimiento;
            Validator.validarFechaNula(fechaIngreso,FECHA_INGRESO_REQUERIDA);
            movimiento.fechaIngreso = this.fechaIngreso;
            Validator.validarFechaNula(fechaSalida,FECHA_SALIDA_REQUERIDA);
            movimiento.fechaSalida = this.fechaSalida;
            Validator.validarPlacaNula(placa,PLACA_REQUERIDA);
            Validator.validarPlacaVacia(placa,PLACA_REQUERIDA);
            movimiento.placa = this.placa;
            movimiento.detalleMovimiento = this.detalleMovimiento;
            movimiento.repuesto = this.repuesto;
            return movimiento;
        }
    }
}
