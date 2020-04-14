package com.ansaca.tallerAutomotriz.model.util;

import com.ansaca.tallerAutomotriz.model.Movimiento;
import com.ansaca.tallerAutomotriz.model.businessexception.BusinessException;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validator {

    public static void validarNombreNulo(String nombre, String mensaje) throws BusinessException{
        if(nombre == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarNombreVacio(String nombre, String mensaje) throws BusinessException{
        if(nombre.isEmpty()){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarApellidoNulo(String apellidos, String mensaje) throws BusinessException{
        if(apellidos == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarApellidoVacio(String apellidos, String mensaje) throws BusinessException {
        if(apellidos.isEmpty()){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarTelefono(Integer telefono, String mensaje) throws BusinessException {
        if(telefono.toString().length() != 10){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarCorreoNulo(String correo, String mensaje) throws BusinessException {
        if(correo == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarCorreoVacio(String correo, String mensaje) throws BusinessException {
        if(correo.isEmpty()){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarFormatoCorreo(String correo, String mensaje) throws BusinessException {
        String correoPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" + "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";

        Pattern pattern = Pattern.compile(correoPattern);

        Matcher matcher = pattern.matcher(correo);

        if (!matcher.matches()) {
            throw new BusinessException(mensaje);
        }
    }

    public static void validarDirecionNulo(String direccion, String mensaje) throws BusinessException {
        if(direccion == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarDirecionVacia(String direccion, String mensaje) throws BusinessException{
        if(direccion.isEmpty()){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarEspecialidadNula(String especialidad, String mensaje) throws BusinessException {
        if(especialidad == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarEspecialidadVacia(String especialidad, String mensaje) throws BusinessException {
        if(especialidad.isEmpty()){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarDisponibilidadNula(Boolean disponibilidad, String mensaje) throws BusinessException {
        if(disponibilidad == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarPagoValorNegativo(double pago, String mensaje) throws BusinessException {
        if(pago < 0){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarPlacaNula(String placa, String mensaje) throws BusinessException {
        if(placa == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarPlacaVacia(String placa, String mensaje) throws BusinessException {
        if(placa.isEmpty()){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarNumeroCaracteresPlaca(String placa, String mensaje) throws BusinessException {
        if (placa.length() != 5 && placa.length() != 6){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarEstadoNulo(Boolean estado, String mensaje) throws BusinessException {
        if(estado == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarTipoVehiculoNulo(String tipoVehiculo, String mensaje) throws BusinessException {
        if(tipoVehiculo == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarTipoVehiculoVacio(String tipoVehiculo, String mensaje) throws BusinessException {
        if(tipoVehiculo.isEmpty()){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarObjetoNulo(Object object, String mensaje) throws BusinessException {
        if(object == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarFechaNula(Date fecha, String mensaje) throws BusinessException {
        if(fecha == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarDescripcionNulo(String descripcion, String mensaje) throws  BusinessException {
        if(descripcion==null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarDescripcionVacia(String descripcion, String mensaje) throws BusinessException {
        if(descripcion.isEmpty()){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarPagoValorCero(double pago, String mensaje) throws BusinessException{
        if(pago == 0){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarCantidadIncorrecta(Integer cantidad, String mensaje) throws BusinessException {
        if(cantidad <= 0){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarManoObraIncorrecta(double valorManoObra, String mensaje) throws BusinessException {
        if(valorManoObra <= 0){
            throw new BusinessException(mensaje);
        }
    }
}
