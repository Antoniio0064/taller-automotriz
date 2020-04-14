package com.ansaca.tallerAutomotriz.model;

import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepuestoTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void crearObjetoConNombreNulo() throws BusinessException {
        exception.expect(BusinessException.class);
        exception.expectMessage(Repuesto.NOMBRE_REQUERIDO);
        Repuesto repuesto = new Repuesto.RepuestoBuilder()
                .setIdRepuesto(2)
                .build();
    }

    @Test
    public void crearObjetoConNombreVacio() throws BusinessException {
        exception.expect(BusinessException.class);
        exception.expectMessage(Repuesto.NOMBRE_REQUERIDO);
        Repuesto repuesto = new Repuesto.RepuestoBuilder()
                .setIdRepuesto(1)
                .setNombre("")
                .build();
    }

    @Test
    public void crearObjetoConDescripcionNula() throws BusinessException {
        exception.expect(BusinessException.class);
        exception.expectMessage(Repuesto.DESCRIPCION_REQUERIDO);
        Repuesto respuesto =new Repuesto.RepuestoBuilder()
                .setIdRepuesto(1)
                .setNombre("bateria")
                .build();
    }

    @Test
    public void crearObjetoConDescripcionVacia() throws BusinessException {
        exception.expect(BusinessException.class);
        exception.expectMessage(Repuesto.DESCRIPCION_REQUERIDO);
        Repuesto respuesto =new Repuesto.RepuestoBuilder()
                .setIdRepuesto(1)
                .setNombre("bateria")
                .setDescripcion("")
                .build();
    }

    @Test
    public void crearObjetoConValorNegativo() throws BusinessException {
        exception.expect(BusinessException.class);
        exception.expectMessage(Repuesto.VALOR_NEGATIVO);
        Repuesto repuesto = new Repuesto.RepuestoBuilder()
                .setIdRepuesto(1)
                .setNombre("bateria")
                .setDescripcion("para motos")
                .setValor(-2.500)
                .build();
    }

    @Test
    public void crearObjetoConValorCero() throws BusinessException {
        exception.expect(BusinessException.class);
        exception.expectMessage(Repuesto.VALOR_CERO);
        Repuesto repuesto = new Repuesto.RepuestoBuilder()
                .setIdRepuesto(1)
                .setNombre("bateria")
                .setDescripcion("para motos")
                .setValor(0.0)
                .build();
    }

    @Test
    public void crearObjetoConCantidadIncorrecta() throws BusinessException {
        exception.expect(BusinessException.class);
        exception.expectMessage(Repuesto.CANTIDAD_NO_VALIDA);
        Repuesto repuesto = new Repuesto.RepuestoBuilder()
                .setIdRepuesto(1)
                .setNombre("bateria")
                .setDescripcion("para motos")
                .setValor(10.000)
                .setCantidad(-5000)
                .build();
    }

}