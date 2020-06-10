package com.ansaca.tallerAutomotriz.model;

import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;
import com.ansaca.tallerAutomotriz.model.util.Validator;

import javax.xml.bind.ValidationEvent;

public class Mecanico extends Persona {

    public static final String ESPECIALIDAD_REQUERIDA = "La informacion sobre la especialidad del mecanico es requerida";
    public static final String DISPONIBILIDAD_REQUERIDA = "El estado de disponibilidad del mecanico es requerida";
    public static final String NOMBRE_REQUERIDO = "El nombre de una persona es requerido";
    public static final String APELLIDO_REQUERIDO = "El apellido de una persona es requerida";
    public static final String TELEFONO_INVALIDO = "el formato del telefono debe contener 10 dígitos";
    public static final String CORREO_REQUERIDO = "El correo de una persona es requerido";
    public static final String CORREO_FORMATO_INCORRECTO = "el formato ingresado de correo no es el correcto";
    public static final String DIRECCION_REQUERIDA = "La direccion de residencia de una persona es requerida";

    private Integer idMecanico;
    private String especialidad;
    private Boolean disponibilidad;


    public static class MecanicoBuilder{

        private Integer idMecanico;
        private String especialidad;
        private Boolean disponibilidad;

        //Persona
        private Integer idPersona;
        private String nombre;
        private String apellidos;
        private Integer telefono;
        private String correo;
        private String direccion;

        public MecanicoBuilder setIdPersona(Integer idPersona) {
            this.idPersona = idPersona;
            return this;
        }

        public MecanicoBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public MecanicoBuilder setApellidos(String apellidos) {
            this.apellidos = apellidos;
            return this;
        }

        public MecanicoBuilder setTelefono(Integer telefono) {
            this.telefono = telefono;
            return this;
        }

        public MecanicoBuilder setCorreo(String correo) {
            this.correo = correo;
            return this;
        }

        public MecanicoBuilder setDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public MecanicoBuilder setIdMecanico(Integer idMecanico) {
            this.idMecanico = idMecanico;
            return this;
        }

        public MecanicoBuilder setEspecialidad(String especialidad) {
            this.especialidad = especialidad;
            return this;
        }

        public MecanicoBuilder setDisponibilidad(Boolean disponibilidad) {
            this.disponibilidad = disponibilidad;
            return this;
        }


        public Mecanico build() throws BusinessException{
            Mecanico mecanico = new Mecanico();
            mecanico.idMecanico = this.idMecanico;
            mecanico.setIdPersona(this.idPersona);
            Validator.validarNombreNulo(nombre, NOMBRE_REQUERIDO);
            Validator.validarNombreVacio(nombre, NOMBRE_REQUERIDO);
            mecanico.setNombre(this.nombre);
            Validator.validarApellidoNulo(apellidos, APELLIDO_REQUERIDO);
            Validator.validarApellidoVacio(apellidos, APELLIDO_REQUERIDO);
            mecanico.setApellidos(this.apellidos);
            Validator.validarTelefono(telefono, TELEFONO_INVALIDO);
            mecanico.setTelefono(this.telefono);
            Validator.validarCorreoNulo(correo, CORREO_REQUERIDO);
            Validator.validarCorreoVacio(correo, CORREO_REQUERIDO);
            Validator.validarFormatoCorreo(correo, CORREO_FORMATO_INCORRECTO);
            mecanico.setCorreo(this.correo);
            Validator.validarDirecionNulo(direccion, DIRECCION_REQUERIDA);
            Validator.validarDirecionVacia(direccion, DIRECCION_REQUERIDA);
            mecanico.setDireccion(this.direccion);
            Validator.validarEspecialidadNula(especialidad, ESPECIALIDAD_REQUERIDA);
            Validator.validarEspecialidadVacia(especialidad, ESPECIALIDAD_REQUERIDA);
            mecanico.especialidad = this.especialidad;
            Validator.validarDisponibilidadNula(disponibilidad, DISPONIBILIDAD_REQUERIDA);
            mecanico.disponibilidad = this.disponibilidad;
            return mecanico;
        }
    }


    public void actualizarDisponibilidad(){
        if(disponibilidad)
            disponibilidad = false;
        else
            disponibilidad = true;
    }


}
