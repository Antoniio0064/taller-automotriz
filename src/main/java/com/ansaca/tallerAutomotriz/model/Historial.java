package com.ansaca.tallerAutomotriz.model;

import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import com.ansaca.tallerAutomotriz.model.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class Historial {

    public static final String LISTA_MOVIMIENTOS_REQUERIDA = "La lista de movimientos es requerida";

    private Integer idHistorial;
    private List<Movimiento> movimientoList = new ArrayList<Movimiento>();

    public static class HistorialBuilder{
        private Integer idHistorial;
        private List<Movimiento> movimientos = new ArrayList<Movimiento>();

        public HistorialBuilder setIdHistorial(Integer idHistorial) {
            this.idHistorial = idHistorial;
            return this;
        }

        public HistorialBuilder setMovimientos(List<Movimiento> movimientos) {
            this.movimientos = movimientos;
            return this;
        }

        public Historial build() throws BusinessException {
            Historial historial = new Historial();
            historial.idHistorial = this.idHistorial;
            historial.movimientoList = this.movimientos;
            return historial;
        }
    }

    public Integer getIdHistorial() {
        return idHistorial;
    }

    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }
}
