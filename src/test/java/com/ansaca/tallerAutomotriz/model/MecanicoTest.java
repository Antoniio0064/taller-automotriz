package com.ansaca.tallerAutomotriz.model;


import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MecanicoTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void crearObjetoConNombreNulo() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Mecanico.NOMBRE_REQUERIDO);
        Mecanico mecanico = new Mecanico.MecanicoBuilder()
                .setIdMecanico(1)
                .setIdPersona(1)
                .build();
    }

    @Test
    public void crearObjetoConNombreVacio() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Mecanico.NOMBRE_REQUERIDO);
        Mecanico mecanico = new Mecanico.MecanicoBuilder()
                .setIdMecanico(1)
                .setIdPersona(1)
                .setNombre("")
                .build();
    }

    @Test
    public void crearObjetoConApellidoNulo() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Mecanico.APELLIDO_REQUERIDO);
        Mecanico mecanico = new Mecanico.MecanicoBuilder()
                .setIdMecanico(1)
                .setIdPersona(1)
                .setNombre("juanito")
                .build();
    }

    @Test
    public void crearObjetoConApellidoVacio() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Mecanico.APELLIDO_REQUERIDO);
        Mecanico mecanico = new Mecanico.MecanicoBuilder()
                .setIdMecanico(1)
                .setIdPersona(1)
                .setNombre("juanito")
                .setApellidos("")
                .build();
    }

    @Test
    public void crearObjetoConTelefonoIncorrecto() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Mecanico.TELEFONO_INVALIDO);
        Mecanico mecanico = new Mecanico.MecanicoBuilder()
                .setIdMecanico(1)
                .setIdPersona(1)
                .setNombre("juanito")
                .setApellidos("lonaranjas")
                .setTelefono(123456)
                .build();
    }

    @Test
    public void crearObjetoConCorreoVacio() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Mecanico.CORREO_REQUERIDO);
        Mecanico mecanico = new Mecanico.MecanicoBuilder()
                .setIdMecanico(1)
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
        exception.expectMessage(Mecanico.CORREO_REQUERIDO);
        Mecanico mecanico = new Mecanico.MecanicoBuilder()
                .setIdMecanico(1)
                .setIdPersona(1)
                .setNombre("juanito")
                .setApellidos("lonaranjas")
                .setTelefono(1234567890)
                .build();
    }

    @Test
    public void crearObjetoConCorreoFormatoIncorrecto() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Mecanico.CORREO_FORMATO_INCORRECTO);
        Mecanico mecanico = new Mecanico.MecanicoBuilder()
                .setIdMecanico(1)
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
        exception.expectMessage(Mecanico.DIRECCION_REQUERIDA);
        Mecanico mecanico = new Mecanico.MecanicoBuilder()
                .setIdMecanico(1)
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
        exception.expectMessage(Mecanico.DIRECCION_REQUERIDA);
        Mecanico mecanico = new Mecanico.MecanicoBuilder()
                .setIdMecanico(1)
                .setIdPersona(1)
                .setNombre("juanito")
                .setApellidos("lonaranjas")
                .setTelefono(1234567890)
                .setCorreo("juanito123@hotmail.com")
                .setDireccion("")
                .build();
    }

    @Test
    public void crearObjetoConEspecialidadVacia() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Mecanico.ESPECIALIDAD_REQUERIDA);
        Mecanico mecanico = new Mecanico.MecanicoBuilder()
                .setIdMecanico(1)
                .setIdPersona(1)
                .setNombre("juanito")
                .setApellidos("lonaranjas")
                .setTelefono(1234567890)
                .setCorreo("juanito123@hotmail.com")
                .setDireccion("vereda la aguelita")
                .setEspecialidad("")
                .build();
    }

    @Test
    public void crearObjetoConEspecialidadNula() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Mecanico.ESPECIALIDAD_REQUERIDA);
        Mecanico mecanico = new Mecanico.MecanicoBuilder()
                .setIdMecanico(1)
                .setIdPersona(1)
                .setNombre("juanito")
                .setApellidos("lonaranjas")
                .setTelefono(1234567890)
                .setCorreo("juanito123@hotmail.com")
                .setDireccion("vereda la aguelita")
                .build();
    }

    @Test
    public void crearObjetoConDisponibilidadNula() throws BusinessException{
        exception.expect(BusinessException.class);
        exception.expectMessage(Mecanico.DISPONIBILIDAD_REQUERIDA);
        Mecanico mecanico = new Mecanico.MecanicoBuilder()
                .setIdMecanico(1)
                .setIdPersona(1)
                .setNombre("juanito")
                .setApellidos("lonaranjas")
                .setTelefono(1234567890)
                .setCorreo("juanito123@hotmail.com")
                .setDireccion("vereda la aguelita")
                .setEspecialidad("motos de alto cilindraje")
                .build();
    }

}
