package com.ansaca.tallerAutomotriz.service.propietario.impl;

import com.ansaca.tallerAutomotriz.command.PropietarioCommand;
import com.ansaca.tallerAutomotriz.entity.*;
import com.ansaca.tallerAutomotriz.fabrica.PropietarioFabrica;
import com.ansaca.tallerAutomotriz.model.Movimiento;
import com.ansaca.tallerAutomotriz.model.Propietario;
import com.ansaca.tallerAutomotriz.model.businessexception.*;
import com.ansaca.tallerAutomotriz.repository.PropietarioRepository;
import com.ansaca.tallerAutomotriz.service.movimiento.MovimientoService;
import com.ansaca.tallerAutomotriz.service.persona.PersonaService;
import com.ansaca.tallerAutomotriz.service.propietario.PropietarioService;
import com.ansaca.tallerAutomotriz.service.vehiculo.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioServiceImpl implements PropietarioService {

    private static final String PROPIETARIO_CREADO_EXITOSAMENTE = "El propietario fue registrado exitosamente";
    private static final String PROPIETARIO_YA_REGISTRADO = "El propietario que intenta registrar ya se encuentra en el sistema";
    private static final String PERSONA_NO_ENCONTRADO = "La persona a la que desea asignar como propietario no existe";
    private static final String VEHICULO_NO_REGISTRADO = "El vehiculo del cual dice ser propietario no se encuentra en el sistema";
    private static final String PROPIETARIO_NO_REGISTRADO = "No existe un propietario asociado a esta placa de vehículo";
    private static final String VEHICULO_CON_DUEÑO = "El vehículo ya tiene un dueño";

    @Autowired
    private PropietarioRepository propietarioRepository;

    @Autowired
    private PropietarioFabrica propietarioFabrica;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private MovimientoService movimientoService;

    @Override
    public List<PropietarioCommand> findAll() {
        return propietarioFabrica.entityToCommand(propietarioRepository.findAll());
    }

    @Override
    public String registrarPropietario(PropietarioCommand propietarioCommand) {
        validarExistenciaPersona(propietarioCommand.getIdPersona());
        validarNoExistaPropietario(propietarioCommand);
        validarExistenciaVehiculo(propietarioCommand.getPlaca());
        validarVehiculoConDueño(propietarioCommand.getPlaca());

        PropietarioEntity  propietarioEntity = new PropietarioEntity();
        propietarioEntity.setPago(propietarioCommand.getPago());
        propietarioEntity.setIdPersona(propietarioCommand.getIdPersona());
        propietarioEntity.setPlaca(propietarioCommand.getPlaca());
        propietarioRepository.save(propietarioEntity);

        return PROPIETARIO_CREADO_EXITOSAMENTE;
    }

    @Override
    public String eliminarPropietario(Integer id) {
        if(propietarioRepository.findByIdPersona(id) != null){
            propietarioRepository.deleteById(id);
            return "Elininado exitosamente";
        }
        return "El mecanico que intenta eliminar no existe!";
    }

    @Override
    public String actualizarPropietario(PropietarioCommand propietarioCommand) {
        validarExistenciaPersona(propietarioCommand.getIdPersona());

        PropietarioEntity propietarioEntity = propietarioRepository.findByIdPersona(propietarioCommand.getIdPersona());
        propietarioEntity.setPago(propietarioCommand.getPago());
        propietarioEntity.setIdPersona(propietarioCommand.getIdPersona());
        propietarioEntity.setPlaca(propietarioCommand.getPlaca());
        propietarioRepository.save(propietarioEntity);
        return "Actualizacion Exitosa";
    }

    private void validarVehiculoConDueño(String placa) {
        PropietarioEntity propietarioEntity = propietarioRepository.findByPlaca(placa);
        if(propietarioEntity != null)
            throw new PropietarioDeEseVehiculoYaExisteException(VEHICULO_CON_DUEÑO);
    }

    @Override
    public Propietario consultarInformacionPropietario(String placa) throws BusinessException {
        PropietarioEntity propietarioEntity = propietarioRepository.findByPlaca(placa);
        validarExistenciaPropietario(propietarioEntity);
        validarExistenciaVehiculo(placa);
        PersonaEntity personaEntity = personaService.findById(propietarioEntity.getIdPersona());
        VehiculoEntity vehiculoEntity = vehiculoService.findByPlaca(placa);
        List<MovimientoEntity> listaMovimientosEntity = movimientoService.findAllByPlaca(placa);
        List<Movimiento> movimientos = movimientoService.entityToModel(listaMovimientosEntity);
        return propietarioFabrica.entityToModel(propietarioEntity, personaEntity, vehiculoEntity, movimientos);
    }

    private void validarExistenciaPropietario(PropietarioEntity propietarioEntity) {
        if(propietarioEntity == null)
            throw new PropietarioNoExisteException(PROPIETARIO_NO_REGISTRADO);
    }

    private void validarExistenciaVehiculo(String placa) {
        if(vehiculoService.findByPlaca(placa) == null)
            throw new VehiculoNoExisteException(VEHICULO_NO_REGISTRADO);
    }

    private void validarNoExistaPropietario(PropietarioCommand propietarioCommand) {
        int idPersona = propietarioCommand.getIdPersona();
        List<PropietarioEntity> list = propietarioRepository.findAll();

        for(PropietarioEntity pe : list){
            if(pe.getIdPersona() == idPersona)
                throw new PropietarioYaExisteException(PROPIETARIO_YA_REGISTRADO);
        }
    }

    private void validarExistenciaPersona(Integer idPersona) {
        if(personaService.findById(idPersona) == null)
            throw new PersonaNoExisteException(PERSONA_NO_ENCONTRADO);
    }
}
