package com.ansaca.tallerAutomotriz.model;

import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import com.ansaca.tallerAutomotriz.model.util.Validator;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

public class Vehiculo {

    public static final String PLACA_REQUERIDA = "La placa de un vehiculo es requerida";
    public static final String NUMERO_DIGITOS_INCORRECTO = "El numero de caracteres de la placa de un vehiculo debe ser de minimo 5 y maximo 6 caracteres";
    public static final String ESTADO_REQUERIDO = "El estado en el que se encuentra un vehiculo es requerido";
    public static final String TIPO_VEHICULO_REQUERIDO = "La informacion acerca del tipo de vehículo es requerida";
    public static final String HISTORIAL_NO_CONFIGURADO = "La informacion acerca del tipo de vehículo es requerida";

    private Integer idVehiculo;
    private String placa;
    private Boolean estado;
    private String tipoVehiculo;
    private List<Movimiento> movimientos = new ArrayList<Movimiento>();

    public static class VehiculoBuilder{
        private Integer idVehiculo;
        private String placa;
        private Boolean estado;
        private String tipoVehiculo;
        private List<Movimiento> movimientos = new ArrayList<Movimiento>();

        public VehiculoBuilder setIdVehiculo(Integer idVehiculo) {
            this.idVehiculo = idVehiculo;
            return this;
        }

        public VehiculoBuilder setPlaca(String placa) {
            this.placa = placa;
            return this;
        }

        public VehiculoBuilder setEstado(boolean estado) {
            this.estado = estado;
            return this;
        }

        public VehiculoBuilder setTipoVehiculo(String tipoVehiculo) {
            this.tipoVehiculo = tipoVehiculo;
            return this;
        }

        public VehiculoBuilder setMovimientos(List<Movimiento> movimientos) {
            this.movimientos = movimientos;
            return this;
        }

        public Vehiculo build() throws BusinessException{
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.idVehiculo = this.idVehiculo;
            Validator.validarPlacaNula(placa, PLACA_REQUERIDA);
            Validator.validarPlacaVacia(placa, PLACA_REQUERIDA);
            Validator.validarNumeroCaracteresPlaca(placa, NUMERO_DIGITOS_INCORRECTO);
            vehiculo.placa = this.placa;
            Validator.validarEstadoNulo(estado, ESTADO_REQUERIDO);
            vehiculo.estado = this.estado;
            Validator.validarTipoVehiculoNulo(tipoVehiculo, TIPO_VEHICULO_REQUERIDO);
            Validator.validarTipoVehiculoVacio(tipoVehiculo, TIPO_VEHICULO_REQUERIDO);
            vehiculo.tipoVehiculo = this.tipoVehiculo;
            vehiculo.movimientos = this.movimientos;
            return vehiculo;
        }
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public Boolean getEstado() {
        return estado;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }
}
