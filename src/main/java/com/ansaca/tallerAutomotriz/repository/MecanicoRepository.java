package com.ansaca.tallerAutomotriz.repository;

import com.ansaca.tallerAutomotriz.entity.MecanicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MecanicoRepository extends JpaRepository<MecanicoEntity, Integer> {
    MecanicoEntity findByIdPersona(Integer idPersona);
}
