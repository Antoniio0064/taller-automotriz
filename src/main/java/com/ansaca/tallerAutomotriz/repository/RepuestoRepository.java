package com.ansaca.tallerAutomotriz.repository;

import com.ansaca.tallerAutomotriz.entity.RepuestoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestoRepository extends JpaRepository<RepuestoEntity, Integer> {
}
