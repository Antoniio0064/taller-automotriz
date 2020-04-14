package com.ansaca.tallerAutomotriz.model;

import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovimientoTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void crearObjetoSinFechaEntrada() throws BusinessException {
        exception.expect(BusinessException.class);
        exception.expectMessage(Movimiento.FECHA_INGRESO_REQUERIDA);
        Movimiento movimiento = new Movimiento.MovimientoBuilder()
                .build();
    }

    @Test
    public void crearObjetoSinFechaSalida() throws BusinessException {
        exception.expect(BusinessException.class);
        exception.expectMessage(Movimiento.FECHA_SALIDA_REQUERIDA);
        Movimiento movimiento = new Movimiento.MovimientoBuilder()
                .setFechaIngreso(new Date())
                .build();
    }

    @Test
    public void crearObjetoConPlacaNula() throws BusinessException {
        exception.expect(BusinessException.class);
        exception.expectMessage(Movimiento.PLACA_REQUERIDA);
        Movimiento movimiento = new Movimiento.MovimientoBuilder()
                .setFechaIngreso(new Date())
                .setFechaSalida(new Date())
                .build();
    }

    @Test
    public void crearObjetoConPlacaVacia() throws BusinessException {
        exception.expect(BusinessException.class);
        exception.expectMessage(Movimiento.PLACA_REQUERIDA);
        Movimiento movimiento = new Movimiento.MovimientoBuilder()
                .setFechaIngreso(new Date())
                .setFechaSalida(new Date())
                .setPlaca("")
                .build();
    }

    @Test
    public void crearObjetoConFacturaSinConfigurar() throws BusinessException {
        exception.expect(BusinessException.class);
        exception.expectMessage(Movimiento.FACTURA_NO_CONFIGURADA);
        Movimiento movimiento = new Movimiento.MovimientoBuilder()
                .setFechaIngreso(new Date())
                .setFechaSalida(new Date())
                .setPlaca("MLG904")
                .build();
    }

    @Test
    public void calcularValorAPagar() throws BusinessException {
        Repuesto repuesto1 = new Repuesto.RepuestoBuilder().setIdRepuesto(1).setNombre("llanta").setDescripcion("sadas")
                .setValor(75000).setCantidad(2).build();
        Repuesto repuesto2 = new Repuesto.RepuestoBuilder().setIdRepuesto(2).setNombre("Aceite").setDescripcion("fjdfkg")
                .setValor(15000).setCantidad(1).build();
        List<Repuesto> repuestoList = new ArrayList(){{
            add(repuesto1);
            add(repuesto2);
        }};
        Factura factura = new Factura.FacturaBuilder()
                .setIdFactura(1).setRepuestosList(repuestoList).setValorManoObra(20000)
                .setDescripcionManoObra("cambio aceite y revisión frenos").build();
        Movimiento movimiento = new Movimiento.MovimientoBuilder()
                .setFechaIngreso(new Date())
                .setFechaSalida(new Date())
                .setPlaca("MLG904")
                .setFactura(factura)
                .build();
        double valorReal = movimiento.getFactura().calcularTotalAPagar();
        double valorEsperado = 185000;
        Assert.assertEquals(valorEsperado, valorReal, 1);
    }

}
