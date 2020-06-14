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

}
