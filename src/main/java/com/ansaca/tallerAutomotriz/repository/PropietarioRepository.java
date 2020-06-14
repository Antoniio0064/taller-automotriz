package com.ansaca.tallerAutomotriz.repository;

import com.ansaca.tallerAutomotriz.entity.PropietarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<PropietarioEntity, Integer> {
    PropietarioEntity findByPlaca(String placa);
}
