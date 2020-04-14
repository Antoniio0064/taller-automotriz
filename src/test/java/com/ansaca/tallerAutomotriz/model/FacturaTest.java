package com.ansaca.tallerAutomotriz.model;

import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacturaTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void crearObjetoConManoObraIncorrecta() throws BusinessException {
        exception.expect(BusinessException.class);
        exception.expectMessage(Factura.VALOR_INCORRECTO);
        List<Repuesto> repuestoList = new ArrayList<>();
        Factura factura = new Factura.FacturaBuilder()
                .setIdFactura(1)
                .setRepuestosList(repuestoList)
                .setValorManoObra(0)
                .build();
    }

    @Test
    public void crearObjetoConDescripcionManoObraNula() throws BusinessException {
        exception.expect(BusinessException.class);
        exception.expectMessage(Factura.DESCRIPCION_MANO_OBRA_REQUERIDA);
        List<Repuesto> repuestoList = new ArrayList<>();
        Factura factura = new Factura.FacturaBuilder()
                .setIdFactura(1)
                .setRepuestosList(repuestoList)
                .setValorManoObra(10000)
                .build();
    }

    @Test
    public void crearObjetoConDescripcionManoObraVacia() throws BusinessException {
        exception.expect(BusinessException.class);
        exception.expectMessage(Factura.DESCRIPCION_MANO_OBRA_REQUERIDA);
        List<Repuesto> repuestoList = new ArrayList<>();
        Factura factura = new Factura.FacturaBuilder()
                .setIdFactura(1)
                .setRepuestosList(repuestoList)
                .setValorManoObra(10000)
                .setDescripcionManoObra("")
                .build();
    }
}
