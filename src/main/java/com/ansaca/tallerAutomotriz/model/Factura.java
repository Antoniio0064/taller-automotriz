package com.ansaca.tallerAutomotriz.model;

import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import com.ansaca.tallerAutomotriz.model.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    public static final String VALOR_INCORRECTO = "El valor de la mano de obra no puede ser igual o menor a cero";
    public static final String DESCRIPCION_MANO_OBRA_REQUERIDA = "La descripcion de los procedimientos es requerida";

    private Integer idFactura;
    private List<Repuesto> RepuestosList = new ArrayList<Repuesto>();
    private double valorManoObra;
    private String descripcionManoObra;

    public static class FacturaBuilder{
        private Integer idFactura;
        private List<Repuesto> RepuestosList = new ArrayList<Repuesto>();
        private double valorManoObra;
        private String descripcionManoObra;

        public FacturaBuilder setIdFactura(Integer idFactura) {
            this.idFactura = idFactura;
            return this;
        }

        public FacturaBuilder setRepuestosList(List<Repuesto> repuestosList) {
            RepuestosList = repuestosList;
            return this;
        }

        public FacturaBuilder setValorManoObra(double valorManoObra) {
            this.valorManoObra = valorManoObra;
            return this;
        }

        public FacturaBuilder setDescripcionManoObra(String descripcionManoObra) {
            this.descripcionManoObra = descripcionManoObra;
            return this;
        }

        public Factura build() throws BusinessException{
            Factura factura = new Factura();
            factura.idFactura = this.idFactura;
            factura.RepuestosList = this.RepuestosList;
            Validator.validarManoObraIncorrecta(valorManoObra, VALOR_INCORRECTO);
            factura.valorManoObra = this.valorManoObra;
            Validator.validarDescripcionNulo(descripcionManoObra, DESCRIPCION_MANO_OBRA_REQUERIDA);
            Validator.validarDescripcionVacia(descripcionManoObra, DESCRIPCION_MANO_OBRA_REQUERIDA);
            factura.descripcionManoObra = this.descripcionManoObra;
            return factura;
        }
    }

    public void agregarRepuesto(Repuesto repuesto){
        RepuestosList.add(repuesto);
    }

    public void eliminarRepuesto(Repuesto repuesto){
        RepuestosList.remove(repuesto);
    }

    public double calcularTotalAPagar (){
        double resultado = 0;
        for (Repuesto repuesto : RepuestosList) {
            resultado += (repuesto.getValor() * repuesto.getCantidad());
        }

        resultado += valorManoObra;

        return resultado;
    }


}
