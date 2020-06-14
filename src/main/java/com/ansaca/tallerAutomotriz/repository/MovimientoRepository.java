package com.ansaca.tallerAutomotriz.repository;

import com.ansaca.tallerAutomotriz.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Integer> {
    MovimientoEntity findByPlacaAndFinalizado(String placa, boolean b);

    MovimientoEntity findByPlaca(String placa);

    List<MovimientoEntity> findAllByPlaca(String placa);
}
