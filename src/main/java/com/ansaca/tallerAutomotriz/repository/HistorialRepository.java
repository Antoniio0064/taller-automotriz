package com.ansaca.tallerAutomotriz.repository;

import com.ansaca.tallerAutomotriz.entity.HistorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepository extends JpaRepository<HistorialEntity, Integer> {
}
