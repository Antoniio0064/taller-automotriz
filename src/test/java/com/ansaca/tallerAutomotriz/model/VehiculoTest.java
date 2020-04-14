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
public class VehiculoTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void crearObjetoConPlacaNula() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Vehiculo.PLACA_REQUERIDA);
        Vehiculo vehiculo = new Vehiculo.VehiculoBuilder()
                .setIdVehiculo(1)
                .build();
    }

    @Test
    public void crearObjetoConNombreVacio() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Vehiculo.PLACA_REQUERIDA);
        Vehiculo vehiculo = new Vehiculo.VehiculoBuilder()
                .setIdVehiculo(1)
                .setPlaca("")
                .build();
    }

    @Test
    public void crearObjetoConPlacaLongitudIncorrecta() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Vehiculo.NUMERO_DIGITOS_INCORRECTO);
        Vehiculo vehiculo = new Vehiculo.VehiculoBuilder()
                .setIdVehiculo(1)
                .setPlaca("asd4")
                .build();
    }

    @Test
    public void crearObjetoConEstadoNulo() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Vehiculo.ESTADO_REQUERIDO);
        Vehiculo vehiculo = new Vehiculo.VehiculoBuilder()
                .setIdVehiculo(1)
                .setPlaca("asd45")
                .build();
    }

    @Test
    public void crearObjetoCoTipoVehiculoNulo() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Vehiculo.TIPO_VEHICULO_REQUERIDO);
        Vehiculo vehiculo = new Vehiculo.VehiculoBuilder()
                .setIdVehiculo(1)
                .setPlaca("asd45")
                .setEstado(true)
                .build();
    }

    @Test
    public void crearObjetoConTipoVehiculoVacio() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Vehiculo.TIPO_VEHICULO_REQUERIDO);
        Vehiculo vehiculo = new Vehiculo.VehiculoBuilder()
                .setIdVehiculo(1)
                .setPlaca("asd45")
                .setEstado(false)
                .setTipoVehiculo("")
                .build();
    }
}
