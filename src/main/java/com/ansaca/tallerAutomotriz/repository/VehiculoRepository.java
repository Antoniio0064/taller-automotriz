package com.ansaca.tallerAutomotriz.repository;

import com.ansaca.tallerAutomotriz.entity.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Integer> {
    VehiculoEntity findByPlaca(String placa);

    VehiculoEntity findByIdVehiculo(Integer id);
}
