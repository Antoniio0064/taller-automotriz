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
public class PropietarioTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void crearObjetoConNombreNulo() throws BusinessException {
        exception.expect(BusinessException.class);
        exception.expectMessage(Propietario.NOMBRE_REQUERIDO);
        Propietario propietario = new Propietario.PropietarioBuilder()
                .setIdPropietario(1)
                .setIdPersona(1)
                .build();
    }

    @Test
    public void crearObjetoConNombreVacio() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Mecanico.NOMBRE_REQUERIDO);
        Propietario propietario = new Propietario.PropietarioBuilder()
                .setIdPropietario(1)
                .setIdPersona(1)
                .setNombre("")
                .build();
    }

    @Test
    public void crearObjetoConApellidoNulo() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Propietario.APELLIDO_REQUERIDO);
        Propietario propietario = new Propietario.PropietarioBuilder()
                .setIdPropietario(1)
                .setIdPersona(1)
                .setNombre("juanito")
                .build();
    }

    @Test
    public void crearObjetoConApellidoVacio() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Propietario.APELLIDO_REQUERIDO);
        Propietario propietario = new Propietario.PropietarioBuilder()
                .setIdPropietario(1)
                .setIdPersona(1)
                .setNombre("juanito")
                .setApellidos("")
                .build();
    }

    @Test
    public void crearObjetoConTelefonoIncorrecto() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Propietario.TELEFONO_INVALIDO);
        Propietario propietario = new Propietario.PropietarioBuilder()
                .setIdPropietario(1)
                .setIdPersona(1)
                .setNombre("juanito")
                .setApellidos("lonaranjas")
                .setTelefono(123456)
                .build();
    }

    @Test
    public void crearObjetoConCorreoVacio() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Propietario.CORREO_REQUERIDO);
        Propietario propietario = new Propietario.PropietarioBuilder()
                .setIdPropietario(1)
                .setIdPersona(1)
                .setNombre("juanito")
                .setApellidos("lonaranjas")
                .setTelefono(1234567890)
                .setCorreo("")
                .build();
    }

    @Test
    public void crearObjetoConCorreoNulo() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Propietario.CORREO_REQUERIDO);
        Propietario propietario = new Propietario.PropietarioBuilder()
                .setIdPropietario(1)
                .setIdPersona(1)
                .setNombre("juanito")
                .setApellidos("lonaranjas")
                .setTelefono(1234567890)
                .build();
    }

    @Test
    public void crearObjetoConCorreoFormatoIncorrecto() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Propietario.CORREO_FORMATO_INCORRECTO);
        Propietario propietario = new Propietario.PropietarioBuilder()
                .setIdPropietario(1)
                .setIdPersona(1)
                .setNombre("juanito")
                .setApellidos("lonaranjas")
                .setTelefono(1234567890)
                .setCorreo("juanito123.com")
                .build();
    }

    @Test
    public void crearObjetoConDirecionNula() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Propietario.DIRECCION_REQUERIDA);
        Propietario propietario = new Propietario.PropietarioBuilder()
                .setIdPropietario(1)
                .setIdPersona(1)
                .setNombre("juanito")
                .setApellidos("lonaranjas")
                .setTelefono(1234567890)
                .setCorreo("juanito123@hotmail.com")
                .build();
    }

    @Test
    public void crearObjetoConDireccionVacia() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Propietario.DIRECCION_REQUERIDA);
        Propietario propietario = new Propietario.PropietarioBuilder()
                .setIdPropietario(1)
                .setIdPersona(1)
                .setNombre("juanito")
                .setApellidos("lonaranjas")
                .setTelefono(1234567890)
                .setCorreo("juanito123@hotmail.com")
                .setDireccion("")
                .build();
    }

    @Test
    public void crearObjetoConPagoNegativo() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Propietario.PAGO_NEGATIVO);
        Propietario propietario = new Propietario.PropietarioBuilder()
                .setIdPropietario(1)
                .setIdPersona(1)
                .setNombre("juanito")
                .setApellidos("lonaranjas")
                .setTelefono(1234567890)
                .setCorreo("juanito123@hotmail.com")
                .setDireccion("sjhjhdjdh")
                .setPago(-123)
                .build();
    }

    @Test
    public void crearObjetoConPagoCero() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Propietario.PAGO_VALOR_CERO);
        Propietario propietario = new Propietario.PropietarioBuilder()
                .setIdPropietario(1)
                .setIdPersona(1)
                .setNombre("juanito")
                .setApellidos("lonaranjas")
                .setTelefono(1234567890)
                .setCorreo("juanito123@hotmail.com")
                .setDireccion("sjhjhdjdh")
                .setPago(0)
                .build();
    }
}
