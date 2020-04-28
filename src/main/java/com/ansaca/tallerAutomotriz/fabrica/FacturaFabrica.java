package com.ansaca.tallerAutomotriz.fabrica;

import com.ansaca.tallerAutomotriz.command.FacturaCommand;
import com.ansaca.tallerAutomotriz.entity.FacturaEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FacturaFabrica {

    public List<FacturaCommand> entityToCommand(List<FacturaEntity> listaFacturaEntity){
        List<FacturaCommand> listaFacturaCommand = new ArrayList<>();
        listaFacturaEntity.forEach(e-> listaFacturaCommand.add(entityToCommand(e)));
        return listaFacturaCommand;
    }

    private FacturaCommand entityToCommand(FacturaEntity facturaEntity) {
        FacturaCommand facturaCommand = new FacturaCommand();
        facturaCommand.setIdFactura(facturaEntity.getIdFactura());
        facturaCommand.setValorManoObra(facturaEntity.getValorManoObra());
        facturaCommand.setDescripcionManoObra(facturaEntity.getDescripcionManoObra());
        return facturaCommand;
    }


}
